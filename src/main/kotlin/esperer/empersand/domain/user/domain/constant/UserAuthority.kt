package esperer.empersand.domain.user.domain.constant

import org.springframework.security.core.GrantedAuthority

enum class UserAuthority : GrantedAuthority {

    ROLE_USER, ROLE_ADMIN;

    override fun getAuthority(): String = name
}