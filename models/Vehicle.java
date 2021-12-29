package taxi.models;

import lombok.Data;
import taxi.enumration.VehicleType;

import javax.persistence.*;

@Data
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private VehicleType typeOfVehicle;
    private String model;
    private String color;
    private String plaque;
    @OneToOne
    private User user;
}
