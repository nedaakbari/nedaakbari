package taxi.models;


import lombok.Data;
import taxi.enumration.DriverStatus;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Driver extends User {
    @Id
    int id;
    @OneToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;
    private DriverStatus tripOfDrivar;
    private double distance;
    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driver")
    private List<Trip> trips;
}