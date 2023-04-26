package esperer.empersand.domain.order.persistence.repository

import esperer.empersand.domain.order.persistence.entity.OrderJpaEntity
import esperer.empersand.domain.user.persistence.entity.UserJpaEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface OrderJpaRepository : CrudRepository<OrderJpaEntity, UUID> {
    fun findAllByUserJpaEntity(userJpaEntity: UserJpaEntity): List<OrderJpaEntity>
}