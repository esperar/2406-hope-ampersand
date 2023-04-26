package esperer.empersand.domain.item.presentation

import esperer.empersand.domain.item.presentation.data.request.CreateItemRequest
import esperer.empersand.domain.item.usecase.CreateItemUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/item")
class ItemWebAdapter(
    private val createItemUseCase: CreateItemUseCase
) {

    @PostMapping
    fun createPost(@RequestBody request: CreateItemRequest): ResponseEntity<Void> =
        createItemUseCase.execute(request)
            .let { ResponseEntity.status(HttpStatus.CREATED).build() }
}