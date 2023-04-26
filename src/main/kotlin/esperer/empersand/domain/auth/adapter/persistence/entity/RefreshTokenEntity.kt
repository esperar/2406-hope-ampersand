package esperer.empersand.domain.auth.adapter.persistence.entity

import esperer.empersand.domain.auth.domain.RefreshToken
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import java.util.concurrent.TimeUnit
import javax.persistence.Id

@RedisHash("refresh_token")
data class RefreshTokenEntity(
    @Id
    val refreshToken: String,
    val email: String,
    @TimeToLive(unit = TimeUnit.SECONDS)
    val expiredAt: Int
)

fun RefreshTokenEntity.toDomain() = RefreshToken(refreshToken = refreshToken, email = email, expiredAt = expiredAt)
