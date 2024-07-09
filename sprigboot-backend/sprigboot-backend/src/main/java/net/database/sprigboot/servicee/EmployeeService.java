package net.database.sprigboot.servicee;

import net.database.sprigboot.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface EmployeeService {
Employee saveEmployee(Employee employee);
List<Employee> getAllEmployees();
Employee getEmployeeById(long id);
Employee updateEmployee(Employee employee, long id);

void deleteEmployee(long id);


}
