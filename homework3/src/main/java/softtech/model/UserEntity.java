package softtech.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String mail;
    @Column(nullable = false,unique = true)
    private String userName;
    @Column(nullable = false,unique = true,length = 11)
    private Long phoneNumber;
    @Enumerated(EnumType.STRING)
    private UserEnum userType;
}
