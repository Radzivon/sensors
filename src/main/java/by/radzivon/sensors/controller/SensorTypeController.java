package by.radzivon.sensors.controller;

import by.radzivon.sensors.dto.TypeDto;
import by.radzivon.sensors.service.TypeService;
import by.radzivon.sensors.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SensorTypeController {
    private TypeService sensorTypeService;

    @Autowired
    public SensorTypeController(TypeService sensorTypeService) {
        this.sensorTypeService = sensorTypeService;
    }

    @GetMapping(value = {"type/all"})
    public List<TypeDto> cargoListPage() {
        return Mapper.mapAll(sensorTypeService.getAll(), TypeDto.class);
    }
}
