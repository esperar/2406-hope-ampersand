package esperer.empersand.global.security.principle

import esperer.empersand.domain.user.persistence.entity.UserJpaEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthDetails(
    private val user: UserJpaEntity
): UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> =
        user.roles

    override fun getPassword(): String? = null

    override fun getUsername(): String = user.email

    override fun isAccountNonExpired(): Boolean = false

    override fun isAccountNonLocked(): Boolean = false

    override fun isCredentialsNonExpired(): Boolean = false

    override fun isEnabled(): Boolean = false
}