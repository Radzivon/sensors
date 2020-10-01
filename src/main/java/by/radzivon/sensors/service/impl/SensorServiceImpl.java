package by.radzivon.sensors.service.impl;

import by.radzivon.sensors.exceptions.ResourceNotFoundException;
import by.radzivon.sensors.model.entity.Sensor;
import by.radzivon.sensors.model.entity.Type;
import by.radzivon.sensors.model.entity.Unit;
import by.radzivon.sensors.repository.SensorRepository;
import by.radzivon.sensors.service.SensorService;
import by.radzivon.sensors.service.TypeService;
import by.radzivon.sensors.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class SensorServiceImpl implements SensorService {

    private SensorRepository sensorRepository;
    private UnitService unitService;
    private TypeService typeService;

    @Autowired
    public SensorServiceImpl(SensorRepository sensorRepository, UnitService unitService, TypeService typeService) {
        this.sensorRepository = sensorRepository;
        this.unitService = unitService;
        this.typeService = typeService;
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
    public void update(Long id, Sensor sensor) {
        sensorRepository.save(sensor);
    }

    @Override
    public void save(Sensor sensor) throws ResourceNotFoundException {
        Type type = typeService.getById(sensor.getType().getId());
        Unit unit = unitService.getById(sensor.getUnit().getId());
        sensor.setType(type);
        sensor.setUnit(unit);
        sensorRepository.save(sensor);
    }

    @Override
    public void delete(Sensor sensor) {
        sensorRepository.delete(sensor);
    }
}
