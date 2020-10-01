package by.radzivon.sensors.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "sensor_unit")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Unit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String value;
    @ToString.Exclude
    @OneToOne(mappedBy = "unit")
    private Sensor sensor;
    @ManyToOne
    @JoinColumn(name = "FK_typeId")
    private Type type;
}
