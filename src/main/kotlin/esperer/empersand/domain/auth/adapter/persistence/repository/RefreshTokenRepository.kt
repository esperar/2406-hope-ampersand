package esperer.empersand.domain.auth.adapter.persistence.repository

import esperer.empersand.domain.auth.adapter.persistence.entity.RefreshTokenEntity
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository: CrudRepository<RefreshTokenEntity, String> {
}
