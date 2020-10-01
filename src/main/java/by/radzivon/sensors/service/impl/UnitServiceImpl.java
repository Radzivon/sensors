package by.radzivon.sensors.service.impl;

import by.radzivon.sensors.exceptions.ResourceNotFoundException;
import by.radzivon.sensors.model.entity.Unit;
import by.radzivon.sensors.repository.UnitRepository;
import by.radzivon.sensors.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl implements UnitService {
    private UnitRepository unitRepository;

    @Autowired
    public UnitServiceImpl(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public Unit getById(Long id) throws ResourceNotFoundException {
        return unitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unit doesn't exist with id " + id));
    }
}
