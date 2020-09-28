package by.radzivon.sensors.service;

import by.radzivon.sensors.exceptions.ResourceNotFoundException;
import by.radzivon.sensors.model.entity.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SensorService {
    Sensor getById(Long id) throws ResourceNotFoundException;

    Page<Sensor> getAll(Pageable pageable);

    void update(Long id, Sensor sensor) throws ResourceNotFoundException;

    void save(Sensor sensor);

    void delete(Sensor sensor);
}
