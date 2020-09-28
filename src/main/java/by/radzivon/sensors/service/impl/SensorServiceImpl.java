package by.radzivon.sensors.service.impl;

import by.radzivon.sensors.exceptions.ResourceNotFoundException;
import by.radzivon.sensors.model.entity.Sensor;
import by.radzivon.sensors.repository.SensorRepository;
import by.radzivon.sensors.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class SensorServiceImpl implements SensorService {
    private SensorRepository sensorRepository;

    @Autowired
    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public Sensor getById(Long id) throws ResourceNotFoundException {
        return sensorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sensor doesn't exist with id " + id));
    }

    @Override
    public Page<Sensor> getAll(Pageable pageable) {
        return sensorRepository.findAll(pageable);
    }

    @Override
    public void update(Long id, Sensor sensor)  {
        sensorRepository.save(sensor);
    }

    @Override
    public void save(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    @Override
    public void delete(Sensor sensor) {
        sensorRepository.delete(sensor);
    }
}
