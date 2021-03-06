package softtech.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentDto {
    private String commentPost;
    private Long productId;
    private Long userId;
}
