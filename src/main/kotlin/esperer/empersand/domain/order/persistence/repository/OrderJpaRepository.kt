package esperer.empersand.domain.order.persistence.repository

import esperer.empersand.domain.order.persistence.entity.OrderJpaEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface OrderJpaRepository : CrudRepository<OrderJpaEntity, UUID> {

}