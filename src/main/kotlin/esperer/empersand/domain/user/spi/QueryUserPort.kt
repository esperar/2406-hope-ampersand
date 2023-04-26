package esperer.empersand.domain.user.spi

import esperer.empersand.domain.user.domain.User

interface QueryUserPort {
    fun queryUserByEmail(email: String): User
}