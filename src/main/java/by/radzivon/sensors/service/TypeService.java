package by.radzivon.sensors.service;

import by.radzivon.sensors.exceptions.ResourceNotFoundException;
import by.radzivon.sensors.model.entity.Type;

import java.util.List;

public interface TypeService {
    Type getById(Long id) throws ResourceNotFoundException;
    List<Type> getAll();
}
