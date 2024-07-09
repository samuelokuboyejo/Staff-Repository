package net.database.sprigboot.service.impl;

import net.database.sprigboot.exception.ResourceNotFounException;
import net.database.sprigboot.model.Employee;
import net.database.sprigboot.repository.EmployeeRepository;
import net.database.sprigboot.servicee.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
//        Optional<Employee> employee = employeeRepository.findById(id);
//        if(employee.isPresent()){
//            return employee.get();
//        }
//        else {
//            throw new ResourceNotFounException("Employee", "id", id);
//        }

        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFounException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {

        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFounException("Employee", "id", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);

        return null;
    }

    @Override
    public void deleteEmployee(long id) {

        employeeRepository.findById(id).orElseThrow(() -> new
                ResourceNotFounException("Employee", "Id", id));

        employeeRepository.deleteById(id);
    }


}