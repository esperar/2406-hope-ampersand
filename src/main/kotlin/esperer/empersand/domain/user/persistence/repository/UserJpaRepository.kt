package esperer.empersand.domain.user.persistence.repository

import esperer.empersand.domain.user.persistence.entity.UserJpaEntity
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserJpaRepository : CrudRepository<UserJpaEntity, UUID> {
    fun findByEmail(email: String): UserJpaEntity?
}