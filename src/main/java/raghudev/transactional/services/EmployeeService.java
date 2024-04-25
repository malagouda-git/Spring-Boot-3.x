package raghudev.transactional.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raghudev.transactional.dtos.EmployeeDTO;
import raghudev.transactional.entities.EmployeeEntity;
import raghudev.transactional.exception.ResourceNotFoundException;
import raghudev.transactional.mappers.EmployeeMapper;
import raghudev.transactional.repositories.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    AddressService addressService;

    public EmployeeDTO getEmployee(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findByEmployeeId(id);
        if(employeeEntity==null)
            throw new ResourceNotFoundException(System.currentTimeMillis(), "Employee not found","/getEmployee/");
        return EmployeeMapper.getEmployeeDTO(employeeEntity);
    }

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = employeeRepository.save(EmployeeMapper.getEmployeeEntity(employeeDTO));
        return EmployeeMapper.getEmployeeDTO(employeeEntity);
    }
}
