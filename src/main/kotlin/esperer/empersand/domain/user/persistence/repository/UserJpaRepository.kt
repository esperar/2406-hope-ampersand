package esperer.empersand.domain.user.persistence.repository

import esperer.empersand.domain.user.persistence.entity.UserJpaEntity
import org.springframework.data.repository.CrudRepository

interface UserJpaRepository : CrudRepository<UserJpaEntity, Long> {
    fun findByEmail(email: String): UserJpaEntity?
}