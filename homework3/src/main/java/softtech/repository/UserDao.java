package softtech.repository;

import softtech.model.ProductEntity;
import softtech.model.UserEntity;

import java.util.List;

public interface UserDao{
    UserEntity createUser(UserEntity userEntity);
    List<UserEntity> findAllUsers();
    UserEntity getUserById(Long id);
    UserEntity getUserByName(String userName);
    void deleteUserById(Long id);
    UserEntity updateUser(UserEntity userEntity);
    Boolean isPhoneNumberExists(Long phoneNumber);
    Boolean isUserNameExists(String userName);
}
