package net.database.sprigboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import net.database.sprigboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
