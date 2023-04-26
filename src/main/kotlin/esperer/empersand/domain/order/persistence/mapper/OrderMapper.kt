package esperer.empersand.domain.order.persistence.mapper

import esperer.empersand.domain.item.persistence.mapper.ItemMapper
import esperer.empersand.domain.order.persistence.entity.OrderJpaEntity
import esperer.empersand.domain.order.domain.Order
import esperer.empersand.domain.user.persistence.mapper.UserMapper
import esperer.empersand.global.mapper.GenericMapper
import org.springframework.stereotype.Component

@Component
class OrderMapper(
    private val userMapper: UserMapper,
    private val itemMapper: ItemMapper
) : GenericMapper<Order, OrderJpaEntity>{
    override fun toDomain(entity: OrderJpaEntity): Order =
        entity.let {
            Order(
                id = it.id,
                user = userMapper.toDomain(it.userJpaEntity),
                item = itemMapper.toDomain(it.itemJpaEntity)
            )
        }

    override fun toEntity(domain: Order): OrderJpaEntity =
        domain.let{
            OrderJpaEntity(
                id = it.id,
                userJpaEntity = userMapper.toEntity(it.user),
                itemJpaEntity = itemMapper.toEntity(it.item)
            )
    }
}