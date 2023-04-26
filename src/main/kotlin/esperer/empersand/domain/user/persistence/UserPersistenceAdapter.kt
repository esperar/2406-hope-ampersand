package esperer.empersand.domain.user.persistence

import esperer.empersand.domain.user.domain.User
import esperer.empersand.domain.user.exception.UserNotFoundException
import esperer.empersand.domain.user.persistence.mapper.UserMapper
import esperer.empersand.domain.user.persistence.repository.UserJpaRepository
import esperer.empersand.domain.user.spi.UserPort
import esperer.empersand.global.annotation.Adapter

@Adapter
class UserPersistenceAdapter(
    private val userMapper: UserMapper,
    private val userJpaRepository: UserJpaRepository
) : UserPort {

    override fun queryUserByEmail(email: String): User =
        userJpaRepository.findByEmail(email)
            .let { it ?: throw UserNotFoundException() }
            .let { userMapper.toDomain(it) }
}