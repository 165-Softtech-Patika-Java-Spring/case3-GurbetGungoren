package softtech.converter;

import org.springframework.stereotype.Service;
import softtech.dto.UserDto;
import softtech.dto.UserResponse;
import softtech.model.UserEntity;
@Service
public class UserConverter {
    public UserEntity convertToUser(UserDto userDto){
        UserEntity user = new UserEntity();
        user.setUserName(userDto.getUserName());
        user.setUserType(userDto.getUserType());
        user.setMail(userDto.getMail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        return user;
    }

    public UserResponse convertToUserResponse(UserEntity userEntity){
        UserResponse userResponse= new UserResponse();
        userResponse.setId(userEntity.getId());
        userResponse.setUserName(userEntity.getUserName());
        userResponse.setUserType(userEntity.getUserType());
        userResponse.setMail(userEntity.getMail());
        userResponse.setPhoneNumber(userEntity.getPhoneNumber());
        return userResponse;
    }

}
