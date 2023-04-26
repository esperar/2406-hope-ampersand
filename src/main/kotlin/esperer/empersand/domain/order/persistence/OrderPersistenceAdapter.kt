package esperer.empersand.domain.order.persistence

import esperer.empersand.domain.order.domain.Order
import esperer.empersand.domain.order.persistence.mapper.OrderMapper
import esperer.empersand.domain.order.persistence.repository.OrderJpaRepository
import esperer.empersand.domain.order.spi.OrderPort
import esperer.empersand.domain.user.domain.User
import esperer.empersand.domain.user.persistence.mapper.UserMapper
import esperer.empersand.global.annotation.Adapter

@Adapter
class OrderPersistenceAdapter(
    private val orderJpaRepository: OrderJpaRepository,
    private val orderMapper: OrderMapper,
    private val userMapper: UserMapper
) : OrderPort {

    override fun saveOrder(order: Order) {
        orderJpaRepository.save(orderMapper.toEntity(order))
    }

    override fun queryOrderByUser(user: User): List<Order> =
        orderJpaRepository.findAllByUserJpaEntity(userMapper.toEntity(user))
            .map { orderMapper.toDomain(it) }

}