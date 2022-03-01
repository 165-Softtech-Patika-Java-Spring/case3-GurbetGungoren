package softtech.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softtech.dto.UserDto;
import softtech.dto.UserResponse;
import softtech.exception.ExceptionType;
import softtech.exception.SofttechDataNotFoundException;
import softtech.exception.SofttechValidationException;
import softtech.model.UserEntity;
import softtech.repository.UserDao;
import softtech.converter.UserConverter;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class UserServiceImp implements UserService {
    private final UserDao userDao;
    private final UserConverter userConverter;
    @Override
    public UserResponse createUser(UserDto userDto) {

        UserEntity user =userDao.createUser(userConverter.convertToUser(userDto));
        return userConverter.convertToUserResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userDao.findAllUsers().stream()
                .map(userConverter::convertToUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(Long id) {
        UserEntity userById = userDao.getUserById(id);
        return userConverter.convertToUserResponse(userById);
    }

    @Override
    public UserResponse getUserByName(String userName) {
        UserEntity user = userDao.getUserByName(userName);
        return userConverter.convertToUserResponse(user);
    }

    @Override
    public void deleteUserByName(String userName, Long phoneNumber) {
        UserEntity user = userDao.getUserByName(userName);
        if(user.getPhoneNumber()==phoneNumber){
            userDao.deleteUserById(user.getId());
        }
        else{
            throw new SofttechValidationException(ExceptionType.PHONE_NUMBER_DOES_NOT_MATCHING);
        }
    }

    public UserResponse updateUser(Long id,UserDto userDto){
        UserEntity existingUser = userDao.getUserById(id);
        existingUser.setPhoneNumber(userDto.getPhoneNumber());
        existingUser.setUserName(userDto.getUserName());
        existingUser.setMail(userDto.getMail());
        existingUser.setUserType(userDto.getUserType());
        UserEntity uptatedUser = userDao.updateUser(existingUser);
        return userConverter.convertToUserResponse(uptatedUser);

    }
}
