package esperer.empersand.domain.item.usecase

import esperer.empersand.domain.item.presentation.data.response.QueryItemResponse
import esperer.empersand.domain.item.spi.QueryItemPort
import esperer.empersand.domain.user.spi.QueryUserPort
import esperer.empersand.domain.user.spi.UserSecurityPort
import esperer.empersand.global.annotation.ReadOnlyUseCase

@ReadOnlyUseCase
class QueryMyItemUseCase(
    private val queryItemPort: QueryItemPort,
    private val userSecurityPort: UserSecurityPort,
    private val queryUserPort: QueryUserPort
) {

    fun execute(): List<QueryItemResponse> {
        val user = queryUserPort.queryUserByEmail(userSecurityPort.queryCurrentUserEmail())
        val items = queryItemPort.queryItemByUser(user)

        return items.map {
            QueryItemResponse(title = it.title, price = it.price)
        }
    }
}