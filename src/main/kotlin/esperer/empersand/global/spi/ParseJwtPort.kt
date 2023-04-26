package esperer.empersand.global.spi

import org.springframework.security.core.Authentication
import javax.servlet.http.HttpServletRequest

interface ParseJwtPort {
    fun parseAccessToken(request: HttpServletRequest): String?
    fun parseRefreshToken(refreshToken: String): String?
    fun authentication(accessToken: String): Authentication
    fun isRefreshTokenExpired(refreshToken: String): Boolean
}