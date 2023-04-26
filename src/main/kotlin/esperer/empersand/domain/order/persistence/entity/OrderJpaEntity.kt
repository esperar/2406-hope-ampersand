package esperer.empersand.domain.order.persistence.entity

import esperer.empersand.domain.item.persistence.entity.ItemJpaEntity
import esperer.empersand.domain.user.persistence.entity.UserJpaEntity
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "order")
class OrderJpaEntity(

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", nullable = false, name = "id")
    val id: UUID,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val userJpaEntity: UserJpaEntity,

    @ManyToOne
    @JoinColumn(name = "item_id")
    val itemJpaEntity: ItemJpaEntity
) {
}