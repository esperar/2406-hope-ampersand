package esperer.empersand.global.spi

import esperer.empersand.domain.user.adapter.presentation.data.response.TokenResponse

interface GenerateJwtPort {

    fun generate(email: String): TokenResponse
}