package by.radzivon.sensors.service;

import by.radzivon.sensors.exceptions.ResourceNotFoundException;
import by.radzivon.sensors.model.entity.Unit;

public interface UnitService {
    Unit getById(Long id) throws ResourceNotFoundException;
}
