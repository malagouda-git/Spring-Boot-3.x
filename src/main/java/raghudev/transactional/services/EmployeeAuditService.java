package raghudev.transactional.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raghudev.transactional.entities.EmployeeAuditEntity;
import raghudev.transactional.repositories.EmployeeAuditRepository;
import raghudev.transactional.repositories.EmployeeRepository;

@Service
public class EmployeeAuditService {

    @Autowired
    private EmployeeAuditRepository employeeAuditRepository;

    public void saveEmployeeAudit(EmployeeAuditEntity employeeAuditEntity){
        employeeAuditRepository.save(employeeAuditEntity);
    }
}
