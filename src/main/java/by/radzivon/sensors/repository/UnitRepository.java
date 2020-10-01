package by.radzivon.sensors.repository;

import by.radzivon.sensors.model.entity.Unit;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitRepository extends CrudRepository<Unit, Long> {
    Optional<Unit> findById(Long id);
}
