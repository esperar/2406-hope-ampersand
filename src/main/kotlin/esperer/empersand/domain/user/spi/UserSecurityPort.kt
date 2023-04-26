package esperer.empersand.domain.user.spi

interface UserSecurityPort {
    fun queryCurrentUserEmail(): String
}