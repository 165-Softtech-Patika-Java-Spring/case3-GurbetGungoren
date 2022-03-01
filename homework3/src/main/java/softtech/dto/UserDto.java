package softtech.dto;

import lombok.Builder;
import lombok.Getter;
import softtech.model.UserEnum;
@Getter
@Builder

public class UserDto {

    private String mail;
    private String userName;
    private Long phoneNumber;
    private UserEnum userType;

}
