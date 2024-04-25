package raghudev.transactional.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import raghudev.transactional.entities.EmployeeAuditEntity;

public interface EmployeeAuditRepository extends JpaRepository<EmployeeAuditEntity,Long> {
}
