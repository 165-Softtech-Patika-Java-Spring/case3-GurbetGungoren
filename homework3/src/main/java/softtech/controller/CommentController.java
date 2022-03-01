package softtech.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softtech.dto.CommentDto;
import softtech.dto.CommentResponse;
import softtech.service.CommentService;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/api/v1/comment")
    public ResponseEntity createComment(@RequestBody CommentDto commentDto){
        return ResponseEntity.ok(commentService.createComment(commentDto));
    }
    @GetMapping("/api/v1/userscomment/{userId}")
    public ResponseEntity getAllCommentByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(commentService.getAllCommentByUserId(userId));
    }
    @GetMapping("/api/v1/userscomment/{productId}")
    public ResponseEntity getAllCommentByProductId(@PathVariable Long productId){
        return ResponseEntity.ok(commentService.getAllCommentByProductId(productId));
    }
    @DeleteMapping("/api/v1/comment/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteCommentById(commentId);
    }

}
