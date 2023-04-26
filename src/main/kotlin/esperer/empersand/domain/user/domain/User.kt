package esperer.empersand.domain.user.domain

import esperer.empersand.domain.user.domain.constant.UserAuthority
import esperer.empersand.global.annotation.Aggregate
import java.util.UUID

@Aggregate
data class User(
    val id: UUID,
    val email: String,
    val password: String,
    val name: String,
    val roles: MutableList<UserAuthority>
)