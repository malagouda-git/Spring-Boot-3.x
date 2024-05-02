package raghudev.transactional.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="employee_table")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @NotNull
    private String name;
    private String email;
    private Double salary;
    @OneToMany(targetEntity = AddressEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_fk", referencedColumnName = "employeeId")
    private List<AddressEntity> address;
}
