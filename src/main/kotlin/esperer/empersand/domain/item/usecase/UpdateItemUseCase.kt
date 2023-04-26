package esperer.empersand.domain.item.usecase

import esperer.empersand.domain.item.presentation.data.request.UpdateItemRequest
import esperer.empersand.domain.item.spi.ItemPort
import esperer.empersand.domain.user.spi.QueryUserPort
import esperer.empersand.domain.user.spi.UserSecurityPort
import esperer.empersand.global.annotation.UseCase
import java.util.*

@UseCase
class UpdateItemUseCase(
    private val itemPort: ItemPort,
    private val userSecurityPort: UserSecurityPort,
    private val userPort: QueryUserPort
) {

    fun execute(id: UUID, request: UpdateItemRequest){
        val user = userPort.queryUserByEmail(userSecurityPort.queryCurrentUserEmail())
        itemPort.queryItemByIdAndUser(id, user)
            .let { itemPort.saveItem(
                it.copy(title = request.title, content = request.content, price = request.price)
            ) }
    }
}