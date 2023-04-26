package esperer.empersand.domain.item.persistence

import esperer.empersand.domain.item.domain.Item
import esperer.empersand.domain.item.exception.ItemNotFoundException
import esperer.empersand.domain.item.persistence.mapper.ItemMapper
import esperer.empersand.domain.item.persistence.repository.ItemJpaRepository
import esperer.empersand.domain.item.spi.ItemPort
import esperer.empersand.domain.user.domain.User
import esperer.empersand.domain.user.persistence.mapper.UserMapper
import esperer.empersand.global.annotation.Adapter
import org.springframework.data.repository.findByIdOrNull
import java.util.*

@Adapter
class ItemPersistenceAdapter(
    private val itemJpaRepository: ItemJpaRepository,
    private val itemMapper: ItemMapper,
    private val userMapper: UserMapper
) : ItemPort {

    override fun saveItem(item: Item) {
        itemJpaRepository.save(itemMapper.toEntity(item))
    }

    override fun deleteItem(id: UUID) {
        itemJpaRepository.deleteById(id)
    }

    override fun deleteItemByIdAndUser(id: UUID, user: User) =
        itemJpaRepository.deleteByIdAndUserJpaEntity(id, userMapper.toEntity(user))


    override fun queryItem(): List<Item> =
        itemJpaRepository.findAll()
            .map { itemMapper.toDomain(it) }


    override fun queryItemById(id: UUID): Item =
        itemJpaRepository.findByIdOrNull(id)
            .let { it ?: throw ItemNotFoundException() }
            .let { itemMapper.toDomain(it) }

    override fun queryItemByIdAndUser(id: UUID, user: User): Item =
        itemJpaRepository.findByIdAndUserJpaEntity(id, userMapper.toEntity(user))
            .let { it ?: throw ItemNotFoundException() }
            .let { itemMapper.toDomain(it) }


}