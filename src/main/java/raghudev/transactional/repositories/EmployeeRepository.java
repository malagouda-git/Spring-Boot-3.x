package raghudev.transactional.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import raghudev.transactional.entities.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    EmployeeEntity findByEmployeeId(Long employeeId);
}
