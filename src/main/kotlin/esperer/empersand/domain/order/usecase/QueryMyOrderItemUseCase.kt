package esperer.empersand.domain.order.usecase

import esperer.empersand.domain.item.presentation.data.response.QueryItemResponse
import esperer.empersand.domain.order.spi.QueryOrderPort
import esperer.empersand.domain.user.persistence.mapper.UserMapper
import esperer.empersand.domain.user.spi.QueryUserPort
import esperer.empersand.domain.user.spi.UserSecurityPort
import esperer.empersand.global.annotation.ReadOnlyUseCase

@ReadOnlyUseCase
class QueryMyOrderItemUseCase(
    private val queryOrderPort: QueryOrderPort,
    private val userSecurityPort: UserSecurityPort,
    private val queryUserPort: QueryUserPort,
    private val userMapper: UserMapper
) {

    fun execute() : List<QueryItemResponse> {
        val user = queryUserPort.queryUserByEmail(userSecurityPort.queryCurrentUserEmail())
        val order = queryOrderPort.queryOrderByUser(user)
        return order.map { QueryItemResponse( it.item.title, it.item.price) }
    }
}