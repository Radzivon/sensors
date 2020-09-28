package by.radzivon.sensors.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class SensorDto {

    private long id;
    @NotBlank(message = "Name is required")
    @NotNull(message="Name is required")
    @Size(min=3, max=30, message="Name must be at least 3 and maximum 30 characters long")
    private String name;
    @NotBlank(message = "Model is required")
    @NotNull(message="Model is required")
    @Size(min=3, max=15, message="Model must be at least 3 and maximum 15 characters long")
    private String model;
    @NotNull
    private int rangeFrom;
    @NotNull
    private int rangeTo;
    @Size(min=3, max=40, message="Location must be at least 3 and maximum 40 characters long")
    private String location;
    @Size(min=3, max=40, message="Location must be at least 3 and maximum 40 characters long")
    private String description;
    @NotNull
    private UnitDto unit;
    @NotNull
    private TypeDto type;
}
