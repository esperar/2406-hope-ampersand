package esperer.empersand.domain.item.adapter.persistence.repository

import esperer.empersand.domain.item.adapter.persistence.entity.ItemJpaEntity
import org.springframework.data.repository.CrudRepository

interface ItemJpaRepository : CrudRepository<ItemJpaEntity, Long> {
}