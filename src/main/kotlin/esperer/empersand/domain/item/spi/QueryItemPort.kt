package esperer.empersand.domain.item.spi

import esperer.empersand.domain.item.domain.Item
import esperer.empersand.domain.user.domain.User
import java.util.*

interface QueryItemPort {
    fun queryItem(): List<Item>
    fun queryItemById(id: UUID): Item
    fun queryItemByIdAndUser(id: UUID, user: User): Item
    fun queryItemByUser(user: User): List<Item>
}