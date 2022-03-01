package softtech.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentResponse {
    private Long id;
    private String commentPost;
    private Long productId;
    private Long userId;
    private String userName;

}
