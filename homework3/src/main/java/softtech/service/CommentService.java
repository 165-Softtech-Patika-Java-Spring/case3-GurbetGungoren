package softtech.service;

import softtech.dto.CommentDto;
import softtech.dto.CommentResponse;

import java.util.List;

public interface CommentService {
    CommentResponse createComment(CommentDto commentDto);
    List<CommentResponse> getAllCommentByProductId(Long productId);
    List<CommentResponse> getAllCommentByUserId(Long productId);
    void deleteCommentById(Long id);
}
