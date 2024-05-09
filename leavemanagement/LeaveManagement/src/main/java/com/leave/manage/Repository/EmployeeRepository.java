package com.leave.manage.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.leave.manage.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByUsernameAndPassword(String username, String password);

	
 
}