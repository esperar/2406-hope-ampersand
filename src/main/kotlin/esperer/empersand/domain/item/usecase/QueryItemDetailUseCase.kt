package esperer.empersand.domain.item.usecase

import esperer.empersand.domain.item.presentation.data.response.QueryItemDetailResponse
import esperer.empersand.domain.item.spi.QueryItemPort
import esperer.empersand.global.annotation.ReadOnlyUseCase
import java.util.UUID

@ReadOnlyUseCase
class QueryItemDetailUseCase(
    private val queryItemPort: QueryItemPort
) {

    fun execute(id: UUID): QueryItemDetailResponse {
        val item = queryItemPort.queryItemById(id)
        return QueryItemDetailResponse(
            title = item.title,
            content = item.content,
            price = item.price,
            hostName = item.user.name
        )
    }
}