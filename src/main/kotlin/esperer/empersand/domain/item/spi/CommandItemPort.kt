package esperer.empersand.domain.item.spi

import esperer.empersand.domain.item.domain.Item

interface CommandItemPort {

    fun createItem(item: Item)
    fun updateItem(id: Long)
    fun deleteItem(id: Long)
}