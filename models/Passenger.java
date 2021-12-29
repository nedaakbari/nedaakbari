package taxi.models;

import lombok.Data;
import lombok.ToString;
import taxi.enumration.PassengerStatus;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ToString(callSuper = true)
public class Passenger extends User {
    @Id
    private int id;
    private double balance;//افزایش موجودی
    @Enumerated(EnumType.STRING)
    private PassengerStatus status;
    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "passenger")
    private List<Trip> trips;
}
