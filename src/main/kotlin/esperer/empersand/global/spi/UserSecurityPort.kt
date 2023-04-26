package esperer.empersand.global.spi

interface UserSecurityPort {
    fun getCurrentUserId(): Long
}