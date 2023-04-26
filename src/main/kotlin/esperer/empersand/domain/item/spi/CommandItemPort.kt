package esperer.empersand.domain.item.spi

import esperer.empersand.domain.item.domain.Item
import esperer.empersand.domain.user.domain.User
import java.util.*

interface CommandItemPort {

    fun saveItem(item: Item)
    fun deleteItem(id: UUID)
    fun deleteItemByIdAndUser(id: UUID, user: User)
}