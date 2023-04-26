package esperer.empersand.domain.item.domain

import esperer.empersand.domain.user.domain.User
import esperer.empersand.global.annotation.Aggregate

@Aggregate
data class Item(
    val id: Long,
    val title: String,
    val content: String,
    val price: Long,
    val user: User
)