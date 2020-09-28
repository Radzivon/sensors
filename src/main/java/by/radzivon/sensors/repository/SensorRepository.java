package by.radzivon.sensors.repository;

import by.radzivon.sensors.model.entity.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorRepository extends PagingAndSortingRepository<Sensor, Long> {
    Page<Sensor> findAll(Pageable pageable);

    Optional<Sensor> findById(Long id);

    Sensor save(Sensor sensor);

    void delete(Sensor sensor);
}
