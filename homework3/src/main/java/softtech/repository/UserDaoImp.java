package softtech.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import softtech.exception.ExceptionType;
import softtech.exception.SofttechDataNotFoundException;
import softtech.model.UserEntity;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDaoImp implements UserDao {
    private final UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity
                .orElseThrow(() -> new SofttechDataNotFoundException(ExceptionType.USER_DATA_NOT_FOUND));

    }

    @Override
    public UserEntity getUserByName(String userName) {
        Optional<UserEntity> userEntity = userRepository.findByUserName(userName);
        return userEntity
               .orElseThrow(()->new SofttechDataNotFoundException(ExceptionType.USER_DATA_NOT_FOUND));
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }
}
