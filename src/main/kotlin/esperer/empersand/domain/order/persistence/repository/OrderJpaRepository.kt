package esperer.empersand.domain.order.persistence.repository

import esperer.empersand.domain.order.persistence.entity.OrderJpaEntity
import org.springframework.data.repository.CrudRepository

interface OrderJpaRepository : CrudRepository<OrderJpaEntity, Long> {

}