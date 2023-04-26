package esperer.empersand.domain.order.adapter.persistence.repository

import esperer.empersand.domain.order.adapter.persistence.entity.OrderJpaEntity
import org.springframework.data.repository.CrudRepository

interface OrderJpaRepository : CrudRepository<OrderJpaEntity, Long> {

}