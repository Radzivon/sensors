package by.radzivon.sensors.controller;

import by.radzivon.sensors.dto.SensorDto;
import by.radzivon.sensors.exceptions.ResourceNotFoundException;
import by.radzivon.sensors.model.entity.Sensor;
import by.radzivon.sensors.service.SensorService;
import by.radzivon.sensors.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class SensorController {
    private SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping(value = "sensor/{id}")
    public SensorDto cargoPage(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return Mapper.map(sensorService.getById(id), SensorDto.class);
    }

    @GetMapping(value = {"sensor/all"})
    public Page<SensorDto> cargoListPage(@RequestParam(name = "page", defaultValue = "0") int page,
                                         @RequestParam(name = "pageSize", defaultValue = "4") int pageSize,
                                         @RequestParam(name = "sortBy", defaultValue = "id") String sortBy,
                                         @RequestParam(name = "order", defaultValue = "asc") String sortDir) {
        Pageable paging = PageRequest.of(page, pageSize, Sort.Direction.fromString(sortDir), sortBy);
        return sensorService.getAll(paging).map(this::convertToDto);
    }

    @PostMapping(value = {"sensor/save"})
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCargo(@Valid @RequestBody SensorDto cargoDto) throws ResourceNotFoundException {
        sensorService.save(Mapper.map(cargoDto, Sensor.class));
    }

    @PutMapping(value = "sensor/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void editCargo(@PathVariable("id") Long id, @Valid @RequestBody SensorDto cargoDto) throws ResourceNotFoundException {
        sensorService.update(id, Mapper.map(cargoDto, Sensor.class));
    }

    private SensorDto convertToDto(Sensor part) {
        return Mapper.map(part, SensorDto.class);
    }
}
