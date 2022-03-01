package softtech.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commentPost;

    @ManyToOne
    private ProductEntity productEntity;
    @ManyToOne
    private UserEntity userEntity;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfWriting;


}
