package esperer.empersand.domain.user.security

import esperer.empersand.domain.user.persistence.mapper.UserMapper
import esperer.empersand.domain.user.persistence.repository.UserJpaRepository
import esperer.empersand.domain.user.spi.UserSecurityPort
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