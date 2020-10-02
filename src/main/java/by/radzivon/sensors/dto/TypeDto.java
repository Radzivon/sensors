package by.radzivon.sensors.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeDto {
    private long id;
    private String value;
    private List<UnitDto> units;
}
