package taxi.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import taxi.enumration.Gender;
import taxi.enumration.UserRole;

import javax.persistence.*;
import java.sql.Date;

@Data
@EqualsAndHashCode(of = {"nationalCode"})
@MappedSuperclass
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String name;
    private String family;
    @Temporal(TemporalType.TIME)
    private Date birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phoneNumber;
    private String nationalId;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
