package raghudev.transactional.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raghudev.transactional.dtos.EmployeeDTO;
import raghudev.transactional.entities.EmployeeAuditEntity;
import raghudev.transactional.entities.EmployeeEntity;
import raghudev.transactional.exception.DataPersistanceException;
import raghudev.transactional.exception.ResourceNotFoundException;
import raghudev.transactional.mappers.EmployeeMapper;
import raghudev.transactional.repositories.EmployeeRepository;

import java.time.Instant;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    AddressService addressService;

    @Autowired
    EmployeeAuditService employeeAuditService;

    public EmployeeDTO getEmployee(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findByEmployeeId(id);
        if(employeeEntity==null)
            throw new ResourceNotFoundException(Instant.now(), "Employee not found","/getEmployee/");
        return EmployeeMapper.getEmployeeDTO(employeeEntity);
    }

    @Transactional
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        //employeeDTO.setName(null);
        EmployeeEntity employeeEntity = employeeRepository.save(EmployeeMapper.getEmployeeEntity(employeeDTO));
        /*if(employeeEntity.getName().equals("Ameeth")){
            throw new DataPersistanceException(Instant.now(),"Error in Saving Employee","/saveEmployee");
        }*/
        EmployeeAuditEntity employeeAuditEntity = new EmployeeAuditEntity(null,employeeEntity.getEmployeeId(),employeeEntity.getName(), Instant.now());
        employeeAuditService.saveEmployeeAudit(employeeAuditEntity);
        return EmployeeMapper.getEmployeeDTO(employeeEntity);
    }
}
