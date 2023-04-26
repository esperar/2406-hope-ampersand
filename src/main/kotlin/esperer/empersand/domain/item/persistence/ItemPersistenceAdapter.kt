package esperer.empersand.domain.item.persistence

import esperer.empersand.domain.item.domain.Item
import esperer.empersand.domain.item.persistence.mapper.ItemMapper
import esperer.empersand.domain.item.persistence.repository.ItemJpaRepository
import esperer.empersand.domain.item.presentation.data.request.CreateItemRequest
import esperer.empersand.domain.item.presentation.data.response.QueryItemDetailResponse
import esperer.empersand.domain.item.presentation.data.response.QueryItemResponse
import esperer.empersand.domain.item.spi.ItemPort
import esperer.empersand.domain.user.spi.UserPort
import esperer.empersand.domain.user.spi.UserSecurityPort
import esperer.empersand.global.annotation.Adapter
import java.util.*

@Adapter
class ItemPersistenceAdapter(
    private val itemJpaRepository: ItemJpaRepository,
    private val itemMapper: ItemMapper,
    private val userSecurityPort: UserSecurityPort,
    private val userPort: UserPort
) : ItemPort {

    override fun createItem(item: Item) {
        itemJpaRepository.save(itemMapper.toEntity(item))
    }


    override fun updateItem(id: Long) {
        TODO("Not yet implemented")
    }

    override fun deleteItem(id: Long) {
        TODO("Not yet implemented")
    }

    override fun queryItem(): List<QueryItemResponse> {
        TODO("Not yet implemented")
    }

    override fun queryItemById(id: Long): QueryItemDetailResponse {
        TODO("Not yet implemented")
    }
}