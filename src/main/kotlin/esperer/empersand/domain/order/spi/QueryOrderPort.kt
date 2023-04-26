package esperer.empersand.domain.order.spi

import esperer.empersand.domain.order.domain.Order
import esperer.empersand.domain.user.domain.User

interface QueryOrderPort {
    fun queryOrderByUser(user: User): List<Order>
}