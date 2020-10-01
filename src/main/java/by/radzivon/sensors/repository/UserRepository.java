package by.radzivon.sensors.repository;

import by.radzivon.sensors.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(Long id);

    User save(User user);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
}
