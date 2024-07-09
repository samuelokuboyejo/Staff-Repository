package net.database.sprigboot.controller;

import net.database.sprigboot.model.Employee;
import net.database.sprigboot.servicee.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

@PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);

    }
@GetMapping()
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
}
    @GetMapping({"/{id}"})
    public ResponseEntity<Employee>getEmployeeById(@PathVariable("id") long employeeeId){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeeId), HttpStatus.OK);

    }
    @PutMapping({"id"})
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id
                    ,@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable ("id") long id){
         employeeService.deleteEmployee(id);
         return new ResponseEntity<String>("Employee deleted successflly!", HttpStatus.OK);
    }

}
