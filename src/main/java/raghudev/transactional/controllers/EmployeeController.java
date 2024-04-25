package raghudev.transactional.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import raghudev.transactional.dtos.EmployeeDTO;
import raghudev.transactional.services.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getEmployee/{empId}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long empId){
        return ResponseEntity.ok(employeeService.getEmployee(empId));
    }

    @PostMapping("/saveEmployee")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody  EmployeeDTO employeeDTO){
        return ResponseEntity.ok(employeeService.saveEmployee(employeeDTO));
    }
}
