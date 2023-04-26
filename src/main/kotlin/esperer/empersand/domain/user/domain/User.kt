package esperer.empersand.domain.user.domain

import esperer.empersand.domain.user.domain.constant.UserAuthority
import esperer.empersand.global.annotation.Aggregate

@Aggregate
data class User(
    val id: Long,
    val email: String,
    val password: String,
    val name: String,
    val roles: MutableList<UserAuthority>
)