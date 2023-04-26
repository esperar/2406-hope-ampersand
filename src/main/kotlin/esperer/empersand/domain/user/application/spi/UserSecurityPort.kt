package esperer.empersand.domain.user.application.spi

interface UserSecurityPort {
    fun queryCurrentUserEmail(): String
}