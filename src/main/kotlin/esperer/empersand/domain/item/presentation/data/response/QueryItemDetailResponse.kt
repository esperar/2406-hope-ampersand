package esperer.empersand.domain.item.presentation.data.response

data class QueryItemDetailResponse(
    val title: String,
    val content: String,
    val price: Long,
    val hostName: String
)
