package esperer.empersand.domain.user.adapter.security

import esperer.empersand.domain.user.adapter.persistence.mapper.UserMapper
import esperer.empersand.domain.user.adapter.persistence.repository.UserJpaRepository
import esperer.empersand.domain.user.application.spi.UserSecurityPort
import esperer.empersand.global.annotation.Adapter
import org.springframework.security.core.context.SecurityContextHolder

@Adapter
class UserSecurityAdapter(
    private val userRepository: UserJpaRepository,
    private val userMapper: UserMapper
) : UserSecurityPort {

    override fun queryCurrentUserEmail(): String  =
        SecurityContextHolder.getContext().authentication.name

}