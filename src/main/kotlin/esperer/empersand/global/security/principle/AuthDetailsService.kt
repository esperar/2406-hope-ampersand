package esperer.empersand.global.security.principle

import esperer.empersand.domain.user.persistence.repository.UserJpaRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true, rollbackFor = [Exception::class])
class AuthDetailsService(
    private val userRepository: UserJpaRepository
): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails =
        AuthDetails(userRepository.findByEmail(username) ?: throw RuntimeException())

}