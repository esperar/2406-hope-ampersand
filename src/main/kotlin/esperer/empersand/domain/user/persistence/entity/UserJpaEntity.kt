package esperer.empersand.domain.user.persistence.entity

import esperer.empersand.domain.user.domain.constant.UserAuthority
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "user")
class UserJpaEntity(

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", nullable = false, name = "id")
    val id: UUID,

    val email: String,

    val password: String,

    val name: String,

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_authority", joinColumns = [JoinColumn(name = "user_id")])
    val roles : MutableList<UserAuthority>
)