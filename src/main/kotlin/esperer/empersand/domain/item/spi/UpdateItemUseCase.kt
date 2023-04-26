package esperer.empersand.domain.item.spi

import esperer.empersand.domain.item.presentation.data.request.UpdateItemRequest
import esperer.empersand.domain.user.persistence.mapper.UserMapper
import esperer.empersand.domain.user.spi.UserPort
import esperer.empersand.domain.user.spi.UserSecurityPort
import esperer.empersand.global.annotation.UseCase
import java.util.UUID

@UseCase
class UpdateItemUseCase(
    private val commandItemPort: CommandItemPort,
    private val userSecurityPort: UserSecurityPort,
    private val userPort: UserPort,
    private val userMapper: UserMapper
) {

    fun execute(id: UUID, request: UpdateItemRequest){
        val user = userPort.queryUserByEmail(userSecurityPort.queryCurrentUserEmail())

    }
}