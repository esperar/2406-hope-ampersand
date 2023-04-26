package esperer.empersand.global.security.token

import esperer.empersand.domain.auth.persistence.entity.RefreshTokenEntity
import esperer.empersand.domain.auth.persistence.repository.RefreshTokenRepository
import esperer.empersand.domain.user.presentation.data.response.TokenResponse
import esperer.empersand.global.spi.GenerateJwtPort
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.security.Key
import java.time.LocalDateTime
import java.util.*

@Component
class GenerateJwtAdapter(
    private val jwtProperties: JwtProperties,
    private val refreshTokenRepository: RefreshTokenRepository
): GenerateJwtPort {

    override fun generate(email: String): TokenResponse {
        val accessToken = generateAccessToken(email, jwtProperties.accessSecret)
        val refreshToken = generateRefreshToken(email, jwtProperties.refreshSecret)
        val expiredAt = getAccessTokenExpiredAt()
        refreshTokenRepository.save(RefreshTokenEntity(refreshToken, email, jwtProperties.refreshExp))
        return TokenResponse(accessToken, refreshToken, expiredAt)
    }

    private fun generateAccessToken(email: String, secret: Key): String =
        Jwts.builder()
            .signWith(secret, SignatureAlgorithm.HS256)
            .setSubject(email)
            .claim("type", JwtProperties.accessType)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + jwtProperties.accessExp * 1000))
            .compact()

    private fun generateRefreshToken(email: String, secret: Key): String =
        Jwts.builder()
            .signWith(secret, SignatureAlgorithm.HS256)
            .setSubject(email)
            .claim("type", JwtProperties.refreshType)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + jwtProperties.accessExp * 1000))
            .compact()

    private fun getAccessTokenExpiredAt(): LocalDateTime =
        LocalDateTime.now().plusSeconds(jwtProperties.accessExp.toLong())

}