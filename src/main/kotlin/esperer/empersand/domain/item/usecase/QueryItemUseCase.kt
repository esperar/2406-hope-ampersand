package esperer.empersand.domain.item.usecase

import esperer.empersand.domain.item.presentation.data.response.QueryItemResponse
import esperer.empersand.domain.item.spi.QueryItemPort
import esperer.empersand.global.annotation.ReadOnlyUseCase
import org.springframework.data.annotation.ReadOnlyProperty

@ReadOnlyUseCase
class QueryItemUseCase(
    private val queryItemPort: QueryItemPort
) {

    fun execute(): List<QueryItemResponse>{
        val items = queryItemPort.queryItem()
        return items.map {
            QueryItemResponse(
                title = it.title,
                price = it.price
            )
        }
    }
}