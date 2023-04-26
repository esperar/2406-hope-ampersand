package esperer.empersand.domain.order.domain

import esperer.empersand.domain.item.domain.Item
import esperer.empersand.domain.user.domain.User
import esperer.empersand.global.annotation.Aggregate
import java.util.UUID

@Aggregate
data class Order(
    val id: UUID,
    val user: User,
    val item: Item
)