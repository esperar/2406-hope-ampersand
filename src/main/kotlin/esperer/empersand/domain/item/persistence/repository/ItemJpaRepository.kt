package esperer.empersand.domain.item.persistence.repository

import esperer.empersand.domain.item.persistence.entity.ItemJpaEntity
import esperer.empersand.domain.user.persistence.entity.UserJpaEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface ItemJpaRepository : CrudRepository<ItemJpaEntity, UUID> {
    fun findByIdAndUserJpaEntity(id: UUID, userJpaEntity: UserJpaEntity): ItemJpaEntity?
    fun deleteByIdAndUserJpaEntity(id: UUID, userJpaEntity: UserJpaEntity)
}