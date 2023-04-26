package esperer.empersand.domain.item.usecase

import esperer.empersand.domain.item.spi.CommandItemPort
import esperer.empersand.domain.item.spi.ItemPort
import esperer.empersand.domain.user.spi.UserPort
import esperer.empersand.domain.user.spi.UserSecurityPort
import esperer.empersand.global.annotation.UseCase
import java.util.UUID

@UseCase
class DeleteItemUseCase(
    private val commandItemPort: CommandItemPort,
    private val userPort: UserPort,
    private val userSecurityPort: UserSecurityPort
) {

    fun execute(id: UUID){
        val user = userPort.queryUserByEmail(userSecurityPort.queryCurrentUserEmail())
        commandItemPort.deleteItemByIdAndUser(id, user)
    }
}