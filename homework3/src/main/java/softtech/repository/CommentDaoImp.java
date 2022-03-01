package softtech.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softtech.model.CommentEntity;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentDaoImp implements CommentDao{
    private final CommentRepository commentRepository;
    @Override
    public CommentEntity createComment(CommentEntity commentEntity) {
        return commentRepository.save(commentEntity);
    }

    @Override
    public List<CommentEntity> getAllCommentByProductId(Long id) {
        return commentRepository.findAllByProductEntity_Id(id);
    }

    @Override
    public List<CommentEntity> getAllCommentByUserId(Long id) {
        return commentRepository.findAllByUserEntity_Id(id);
    }

    @Override
    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }
}
