package esperer.empersand.domain.item.spi

import esperer.empersand.domain.item.domain.Item
import java.util.*

interface CommandItemPort {

    fun saveItem(item: Item)
    fun deleteItem(id: UUID)
}