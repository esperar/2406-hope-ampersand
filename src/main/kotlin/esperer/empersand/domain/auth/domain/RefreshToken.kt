package esperer.empersand.domain.auth.domain

import esperer.empersand.global.annotation.Aggregate

@Aggregate
data class RefreshToken(
    val refreshToken: String,
    val email: String,
    val expiredAt: Int
)
