package esperer.empersand.domain.item.usecase

import esperer.empersand.domain.item.domain.Item
import esperer.empersand.domain.item.presentation.data.request.CreateItemRequest
import esperer.empersand.domain.item.spi.CommandItemPort
import esperer.empersand.domain.user.spi.UserPort
import esperer.empersand.domain.user.spi.UserSecurityPort
import esperer.empersand.global.annotation.UseCase
import java.util.UUID

@UseCase
class CreateItemUseCase(
    private val commandItemPort: CommandItemPort,
    private val userSecurityPort: UserSecurityPort,
    private val userPort: UserPort
) {
    fun execute(request: CreateItemRequest){
        val user = userPort.queryUserByEmail(userSecurityPort.queryCurrentUserEmail())

        val item = request.let {
            Item(
                id = UUID.randomUUID(),
                title = it.title,
                content = it.content,
                price = it.price,
                user = user
            )
        }

        commandItemPort.saveItem(item)
    }
}