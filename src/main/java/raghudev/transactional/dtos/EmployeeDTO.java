package raghudev.transactional.dtos;

import lombok.*;
import raghudev.transactional.entities.AddressEntity;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDTO {

    private Long employeeId;
    private String name;
    private String email;
    private double salary;
    private List<AddressEntity> address;
}
