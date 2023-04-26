package esperer.empersand.domain.item.presentation

import esperer.empersand.domain.item.presentation.data.request.CreateItemRequest
import esperer.empersand.domain.item.presentation.data.request.UpdateItemRequest
import esperer.empersand.domain.item.presentation.data.response.QueryItemDetailResponse
import esperer.empersand.domain.item.presentation.data.response.QueryItemResponse
import esperer.empersand.domain.item.usecase.*
import esperer.empersand.domain.order.usecase.CreateOrderUseCase
import esperer.empersand.domain.order.usecase.QueryMyOrderItemUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.management.Query

@RestController
@RequestMapping("/item")
class ItemWebAdapter(
    private val createItemUseCase: CreateItemUseCase,
    private val updateItemUseCase: UpdateItemUseCase,
    private val queryItemUseCase: QueryItemUseCase,
    private val queryItemDetailUseCase: QueryItemDetailUseCase,
    private val deleteItemUseCase: DeleteItemUseCase,
    private val createOrderUseCase: CreateOrderUseCase
) {

    @PostMapping
    fun createItem(@RequestBody request: CreateItemRequest): ResponseEntity<Void> =
        createItemUseCase.execute(request)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }

    @PatchMapping("/{id}")
    fun updateItem(@PathVariable id: UUID, @RequestBody request: UpdateItemRequest): ResponseEntity<Void> =
        updateItemUseCase.execute(id, request)
            .let { ResponseEntity.noContent().build() }

    @GetMapping
    fun queryItem(): ResponseEntity<List<QueryItemResponse>> =
        queryItemUseCase.execute()
            .let { ResponseEntity.ok(it) }

    @GetMapping("/{id}")
    fun queryItemById(@PathVariable id: UUID): ResponseEntity<QueryItemDetailResponse> =
        queryItemDetailUseCase.execute(id)
            .let { ResponseEntity.ok(it) }

    @DeleteMapping("/{id}")
    fun deleteItemById(@PathVariable id: UUID): ResponseEntity<Void> =
        deleteItemUseCase.execute(id)
            .let { ResponseEntity.ok().build() }

    @PostMapping("/{id}/order")
    fun orderItem(@PathVariable id: UUID): ResponseEntity<Void> =
        createOrderUseCase.execute(id)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }


}