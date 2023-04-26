package esperer.empersand.domain.order.spi

import esperer.empersand.domain.order.domain.Order

interface CommandOrderPort {
    fun saveOrder(order: Order)
}