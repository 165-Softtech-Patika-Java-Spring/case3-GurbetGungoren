package softtech.repository;

import softtech.model.CommentEntity;

import java.util.List;

public interface CommentDao {
    CommentEntity createComment(CommentEntity commentEntity);
    List<CommentEntity> getAllCommentByProductId(Long id);
    List<CommentEntity> getAllCommentByUserId(Long id);
    void deleteCommentById(Long id);

}
