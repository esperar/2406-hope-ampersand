package esperer.empersand.domain.item.adapter.persistence.entity

import esperer.empersand.domain.user.adapter.persistence.entity.UserJpaEntity
import javax.persistence.*

@Entity
@Table(name = "item")
class ItemJpaEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    val id: Long,

    val title: String,

    val content: String,

    val price: Long,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val userJpaEntity: UserJpaEntity
) {
}