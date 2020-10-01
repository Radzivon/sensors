package by.radzivon.sensors.service.impl;

import by.radzivon.sensors.exceptions.ResourceNotFoundException;
import by.radzivon.sensors.model.entity.Type;
import by.radzivon.sensors.repository.TypeRepository;
import by.radzivon.sensors.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {

    private TypeRepository typeRepository;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public Type getById(Long id) throws ResourceNotFoundException {
        return typeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Type doesn't exist with id " + id));
    }
}
