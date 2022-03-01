package softtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softtech.model.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long>{

    Optional<UserEntity> findByUserName(String userName);
    Boolean existsByUserName(String userName);
    Boolean existsByPhoneNumber(Long phoneNumber);
}
