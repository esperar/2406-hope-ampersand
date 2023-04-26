package esperer.empersand.domain.auth.persistence.repository

import esperer.empersand.domain.auth.persistence.entity.RefreshTokenEntity
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository: CrudRepository<RefreshTokenEntity, String> {
}
