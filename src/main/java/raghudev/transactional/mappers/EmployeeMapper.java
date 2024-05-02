package raghudev.transactional.mappers;

import raghudev.transactional.dtos.EmployeeDTO;
import raghudev.transactional.entities.EmployeeEntity;

public class EmployeeMapper {

    public static EmployeeDTO getEmployeeDTO(EmployeeEntity employeeEntity){

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(employeeEntity.getEmployeeId());
        employeeDTO.setAddress(employeeEntity.getAddress());
        employeeDTO.setName(employeeEntity.getName());
        employeeDTO.setEmail(employeeEntity.getEmail());
        employeeDTO.setSalary(employeeEntity.getSalary());
        return employeeDTO;

    }

    public static EmployeeEntity getEmployeeEntity(EmployeeDTO employeeDTO){

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmployeeId(employeeDTO.getEmployeeId());
        employeeEntity.setAddress(employeeDTO.getAddress());
        employeeEntity.setName(employeeDTO.getName());
        employeeEntity.setEmail(employeeDTO.getEmail());
        employeeEntity.setSalary(employeeDTO.getSalary());
        return employeeEntity;

    }
}
