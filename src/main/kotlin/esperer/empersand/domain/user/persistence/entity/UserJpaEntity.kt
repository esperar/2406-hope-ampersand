package esperer.empersand.domain.user.persistence.entity

import esperer.empersand.domain.user.domain.constant.UserAuthority
import javax.persistence.*

@Entity
@Table(name = "user")
class UserJpaEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    val id: Long,

    val email: String,

    val password: String,

    val name: String,

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_authority", joinColumns = [JoinColumn(name = "user_id")])
    val roles : MutableList<UserAuthority>
)