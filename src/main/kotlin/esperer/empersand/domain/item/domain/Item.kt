package esperer.empersand.domain.item.domain

import esperer.empersand.domain.user.domain.User
import esperer.empersand.global.annotation.Aggregate
import java.util.UUID

@Aggregate
data class Item(
    val id: UUID,
    val title: String,
    val content: String,
    val price: Long,
    val user: User
)