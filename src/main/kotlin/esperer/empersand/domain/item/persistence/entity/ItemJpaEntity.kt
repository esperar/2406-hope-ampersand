package esperer.empersand.domain.item.persistence.entity

import esperer.empersand.domain.user.persistence.entity.UserJpaEntity
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "item")
class ItemJpaEntity(

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", nullable = false, name = "id")
    val id: UUID,

    val title: String,

    val content: String,

    val price: Long,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val userJpaEntity: UserJpaEntity
) {
}