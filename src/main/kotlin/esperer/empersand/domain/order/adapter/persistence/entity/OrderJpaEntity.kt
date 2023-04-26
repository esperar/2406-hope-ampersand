package esperer.empersand.domain.order.adapter.persistence.entity

import esperer.empersand.domain.item.adapter.persistence.entity.ItemJpaEntity
import esperer.empersand.domain.user.adapter.persistence.entity.UserJpaEntity
import javax.persistence.*

@Entity
@Table(name = "order")
class OrderJpaEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val userJpaEntity: UserJpaEntity,

    @ManyToOne
    @JoinColumn(name = "item_id")
    val itemJpaEntity: ItemJpaEntity
) {
}