package esperer.empersand.domain.item.adapter.persistence.mapper

import esperer.empersand.domain.item.adapter.persistence.entity.ItemJpaEntity
import esperer.empersand.domain.item.domain.Item
import esperer.empersand.domain.user.adapter.persistence.mapper.UserMapper
import esperer.empersand.global.mapper.GenericMapper
import org.springframework.stereotype.Component

@Component
class ItemMapper(
    private val userMapper: UserMapper
    ) : GenericMapper<Item, ItemJpaEntity> {

    override fun toDomain(entity: ItemJpaEntity): Item =
        entity.let {
            Item(
                id = it.id,
                title = it.title,
                content = it.content,
                price = it.price,
                user = userMapper.toDomain(it.userJpaEntity)
            )
        }

    override fun toEntity(domain: Item): ItemJpaEntity =
        domain.let{
            ItemJpaEntity(
                id = it.id,
                title = it.title,
                content = it.content,
                price = it.price,
                userJpaEntity = userMapper.toEntity(it.user)
            )
        }
}