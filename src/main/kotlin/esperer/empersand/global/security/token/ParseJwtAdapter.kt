package esperer.empersand.global.security.token

import esperer.empersand.global.security.principle.AuthDetailsService
import esperer.empersand.global.spi.ParseJwtPort
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.security.Key
import javax.servlet.http.HttpServletRequest

@Component
class ParseJwtAdapter(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService
): ParseJwtPort {

    override fun parseAccessToken(request: HttpServletRequest): String? =
        request.getHeader(JwtProperties.tokenHeader)
            .let { it ?: return null }
            .let { if(it.startsWith(JwtProperties.tokenPrefix)) it.replace(JwtProperties.tokenPrefix, "") else null}

    override fun parseRefreshToken(refreshToken: String): String? =
        if(refreshToken.startsWith(JwtProperties.tokenPrefix)) refreshToken.replace(JwtProperties.tokenPrefix, "") else null

    override fun authentication(accessToken: String): Authentication =
        authDetailsService.loadUserByUsername(getTokenBody(accessToken, jwtProperties.accessSecret).subject)
            .let { UsernamePasswordAuthenticationToken(it, "", it.authorities) }

    override fun isRefreshTokenExpired(refreshToken: String): Boolean {
        runCatching {
            getTokenBody(refreshToken, jwtProperties.refreshSecret).subject
        }.onFailure {
            return true
        }
        return false
    }

    private fun getTokenBody(token: String, secret: Key): Claims =
        Jwts.parserBuilder()
            .setSigningKey(secret)
            .build()
            .parseClaimsJws(token)
            .body

}