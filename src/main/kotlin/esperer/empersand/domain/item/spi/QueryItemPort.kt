package esperer.empersand.domain.item.spi

import esperer.empersand.domain.item.presentation.data.response.QueryItemDetailResponse
import esperer.empersand.domain.item.presentation.data.response.QueryItemResponse

interface QueryItemPort {
    fun queryItem(): List<QueryItemResponse>
    fun queryItemById(id: Long): QueryItemDetailResponse
}