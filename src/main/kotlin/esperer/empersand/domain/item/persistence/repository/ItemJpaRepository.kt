package esperer.empersand.domain.item.persistence.repository

import esperer.empersand.domain.item.persistence.entity.ItemJpaEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface ItemJpaRepository : CrudRepository<ItemJpaEntity, UUID> {
}