package taxi.models;


import lombok.Data;
import taxi.enumration.PayBy;
import taxi.enumration.TripStatus;

import javax.persistence.*;

@Data
@Entity
public class Trip {
    @Transient
    public static final int costEveryMeters = 1000;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Driver driver;
    @ManyToOne
    private Passenger passenger;
    @OneToOne
    private Location origin;//origin  destination
    @OneToOne
    private Location destination;
    private int cost;
    @Enumerated(EnumType.STRING)
    private PayBy payBy;
    @Enumerated(EnumType.STRING)
    private TripStatus tripStatus;


    @Override
    public String toString() {
        return "Trip{" +
                "driver=" + driver +
                ", passenger=" + passenger +
                ", origin=" + origin +
                ", destination=" + destination +
                ", cost=" + cost +
                ", payBy=" + payBy +
                '}';
    }
}
