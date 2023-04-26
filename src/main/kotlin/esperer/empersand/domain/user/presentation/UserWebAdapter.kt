package esperer.empersand.domain.user.presentation

import esperer.empersand.domain.item.presentation.data.response.QueryItemResponse
import esperer.empersand.domain.item.usecase.QueryMyItemUseCase
import esperer.empersand.domain.order.usecase.QueryMyOrderItemUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserWebAdapter(
    private val queryMyOrderItemUseCase: QueryMyOrderItemUseCase,
    private val queryMyItemUseCase: QueryMyItemUseCase
) {

    @GetMapping("/my-order")
    fun queryMyOrder(): ResponseEntity<List<QueryItemResponse>> =
        queryMyOrderItemUseCase.execute()
            .let { ResponseEntity.ok().build() }

    @GetMapping("/my-item")
    fun queryMyItem(): ResponseEntity<List<QueryItemResponse>> =
        queryMyItemUseCase.execute()
            .let { ResponseEntity.ok().build() }
}