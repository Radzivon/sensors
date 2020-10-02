package by.radzivon.sensors.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "sensor_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Type implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String value;
    @ToString.Exclude
    @OneToMany(mappedBy = "type")
    private List<Sensor> sensor;
    @OneToMany(mappedBy = "type")
    private List<Unit> units;
}
