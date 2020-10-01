package by.radzivon.sensors.repository;

import by.radzivon.sensors.model.entity.Type;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TypeRepository extends CrudRepository<Type, Long> {
    Optional<Type> findById(Long id);
}
