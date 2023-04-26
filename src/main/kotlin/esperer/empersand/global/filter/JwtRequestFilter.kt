package esperer.empersand.global.filter

import esperer.empersand.global.spi.ParseJwtPort
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JwtRequestFilter(
    private val parseJwtPort: ParseJwtPort
): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        val accessToken = parseJwtPort.parseAccessToken(request)
        if(!accessToken.isNullOrBlank()){
            val authentication = parseJwtPort.authentication(accessToken)
            SecurityContextHolder.clearContext()
            val securityContext = SecurityContextHolder.getContext()
            securityContext.authentication = authentication
        }
        filterChain.doFilter(request, response)
    }
}
