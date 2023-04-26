package esperer.empersand.domain.order.usecase

import esperer.empersand.domain.item.spi.QueryItemPort
import esperer.empersand.domain.order.domain.Order
import esperer.empersand.domain.order.spi.CommandOrderPort
import esperer.empersand.domain.user.spi.QueryUserPort
import esperer.empersand.domain.user.spi.UserSecurityPort
import esperer.empersand.global.annotation.UseCase
import java.util.UUID

@UseCase
class CreateOrderUseCase(
    private val commandOrderPort: CommandOrderPort,
    private val queryItemPort: QueryItemPort,
    private val userSecurityPort: UserSecurityPort,
    private val userPort: QueryUserPort

) {

    fun execute(itemId: UUID){
        val user = userPort.queryUserByEmail(userSecurityPort.queryCurrentUserEmail())
        val item = queryItemPort.queryItemById(itemId)

        commandOrderPort.saveOrder(
            Order(
                id = UUID.randomUUID(),
                user = user,
                item = item
            )
        )
    }
}