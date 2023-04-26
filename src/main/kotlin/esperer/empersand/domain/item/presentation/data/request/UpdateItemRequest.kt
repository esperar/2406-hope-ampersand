package esperer.empersand.domain.item.presentation.data.request

data class UpdateItemRequest(
    val title: String,
    val content: String,
    val price: Long
)