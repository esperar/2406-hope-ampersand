package esperer.empersand.domain.user.adapter.persistence.repository

import esperer.empersand.domain.user.adapter.persistence.entity.UserJpaEntity
import org.springframework.data.repository.CrudRepository

interface UserJpaRepository : CrudRepository<UserJpaEntity, Long> {
}