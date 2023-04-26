package esperer.empersand.domain.item.spi

import esperer.empersand.domain.item.presentation.data.request.CreateItemRequest

interface CommandItemPort {

    fun createItem(request: CreateItemRequest)
    fun updateItem(id: Long)
    fun deleteItem(id: Long)
}