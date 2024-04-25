package raghudev.transactional.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="employee_table")
public class EmployeeEntity {

    @Id
    @GeneratedValue
    private Long employeeId;
    private String name;
    private String email;
    @OneToMany(targetEntity = AddressEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_fk", referencedColumnName = "employeeId")
    private List<AddressEntity> address;
}
