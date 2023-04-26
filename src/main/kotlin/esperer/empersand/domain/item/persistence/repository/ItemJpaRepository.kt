package esperer.empersand.domain.item.persistence.repository

import esperer.empersand.domain.item.persistence.entity.ItemJpaEntity
import org.springframework.data.repository.CrudRepository

interface ItemJpaRepository : CrudRepository<ItemJpaEntity, Long> {
}