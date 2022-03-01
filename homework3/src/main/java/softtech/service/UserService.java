package softtech.service;

import softtech.dto.UserDto;
import softtech.dto.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserDto userDto);
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);
    UserResponse getUserByName(String userName);
    void deleteUserByName(String userName,Long phoneNumber);
    UserResponse updateUser(Long id,UserDto userDto);
}
