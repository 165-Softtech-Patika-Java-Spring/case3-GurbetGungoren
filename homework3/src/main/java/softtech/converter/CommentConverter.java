package softtech.converter;

import org.springframework.stereotype.Service;
import softtech.dto.CommentDto;
import softtech.dto.CommentResponse;
import softtech.model.CommentEntity;
import softtech.model.ProductEntity;
import softtech.model.UserEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class CommentConverter {
    public CommentEntity convertToEntity(CommentDto commentDto, UserEntity userEntity, ProductEntity productEntity){
        CommentEntity commentEntity=new CommentEntity();
        commentEntity.setUserEntity(userEntity);
        commentEntity.setProductEntity(productEntity);
        commentEntity.setCommentPost(commentDto.getCommentPost());
        commentEntity.setDateOfWriting(new Date());
        return commentEntity;
    }
    public CommentResponse convertToResponse(CommentEntity commentEntity){
        return CommentResponse.builder()
                .id(commentEntity.getId())
                .productId(commentEntity.getProductEntity().getId())
                .userId(commentEntity.getUserEntity().getId())
                .userName(commentEntity.getUserEntity().getUserName())
                .commentPost(commentEntity.getCommentPost())
                .build();
    }
}
