package esperer.empersand.domain.user.adapter.persistence.mapper

import esperer.empersand.domain.user.adapter.persistence.entity.UserJpaEntity
import esperer.empersand.domain.user.adapter.persistence.repository.UserJpaRepository
import esperer.empersand.domain.user.domain.User
import esperer.empersand.global.mapper.GenericMapper
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class UserMapper(
    private val userRepository: UserJpaRepository
): GenericMapper<User, UserJpaEntity> {

    override fun toDomain(entity: UserJpaEntity?): User? =
        entity?.let {
            User(
                id = it.id,
                name = it.name,
                email = it.email,
                password = it.password,
                roles = it.roles
            )
        }

    override fun toEntity(domain: User): UserJpaEntity =
        UserJpaEntity(
            id = domain.id,
            name = domain.name,
            email = domain.email,
            password = domain.password,
            roles = domain.roles
        )
}