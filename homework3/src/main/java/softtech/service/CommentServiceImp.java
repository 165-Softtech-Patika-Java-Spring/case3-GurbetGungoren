package softtech.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softtech.converter.CommentConverter;
import softtech.dto.CommentDto;
import softtech.dto.CommentResponse;
import softtech.exception.ExceptionType;
import softtech.exception.NoDataToDisplayException;
import softtech.model.CommentEntity;
import softtech.model.ProductEntity;
import softtech.model.UserEntity;
import softtech.repository.CommentDao;
import softtech.repository.ProductDao;
import softtech.repository.UserDao;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImp implements CommentService{
    private final CommentDao commentDao;
    private final UserDao userDao;
    private final ProductDao productDao;
    private final CommentConverter commentConverter;
    @Override
    public CommentResponse createComment(CommentDto commentDto) {
        System.out.println(commentDto.getUserId());
        UserEntity user = userDao.getUserById(commentDto.getUserId());
        ProductEntity product = productDao.getProductById(commentDto.getProductId());
        CommentEntity commentEntity = commentConverter.convertToEntity(commentDto, user, product);
        CommentEntity createdComment = commentDao.createComment(commentEntity);
        return commentConverter.convertToResponse(commentEntity);
    }

    @Override
    public List<CommentResponse> getAllCommentByProductId(Long productId) {
        List<CommentEntity> existingCommentList = commentDao.getAllCommentByProductId(productId);
        if (existingCommentList.isEmpty()){
            throw new NoDataToDisplayException(ExceptionType.EMPTY_COMMENT_LIST);
        }
        else{
            return existingCommentList.stream()
                    .map(commentConverter::convertToResponse)
                    .collect(Collectors.toList());
        }
    }
    @Override
    public List<CommentResponse> getAllCommentByUserId(Long productId) {
        List<CommentEntity> existingCommentList = commentDao.getAllCommentByProductId(productId);
        if (existingCommentList.isEmpty()){
            throw new NoDataToDisplayException(ExceptionType.USER_HAS_NO_COMMENT);
        }
        else{
            return existingCommentList.stream()
                    .map(commentConverter::convertToResponse)
                    .collect(Collectors.toList());
        }
    }
    @Override
    public void deleteCommentById(Long id){
        commentDao.deleteCommentById(id);
    }
}
