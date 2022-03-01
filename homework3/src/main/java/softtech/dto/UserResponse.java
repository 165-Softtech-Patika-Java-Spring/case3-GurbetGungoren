package softtech.dto;

import lombok.Data;
import softtech.model.UserEnum;
@Data
public class UserResponse {
    private Long id;
    private String mail;
    private String userName;
    private Long phoneNumber;
    private UserEnum userType;
}
