package com.leave.manage.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.leave.manage.Entity.Employee;
import com.leave.manage.Entity.Role;
import com.leave.manage.Service.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

	    @Autowired
	    private EmployeeService employeeService;
	    
	 
	    @PostMapping("/register")
	    public ResponseEntity<Employee> registerEmployee(@RequestBody Employee employee) {
	       Employee registeredEmployee = employeeService.register(employee);
	        return new ResponseEntity<>(registeredEmployee, HttpStatus.CREATED);
	    }
        
	    
	    @PostMapping("/login")
	    public ResponseEntity<Employee> loginEmployee(@RequestParam("username")  String username, @RequestParam("password") String password) {
	        Employee employee = employeeService.login(username, password);
	        if (employee != null) {
	            return new ResponseEntity<>(employee, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	        }
	    }
	   
	    @GetMapping("/employee/{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
	        Employee employee = employeeService.getEmployeeById(id);
	        return new ResponseEntity<>(employee, HttpStatus.OK);
	    }
	    
	    @GetMapping
	    public ResponseEntity<List<Employee>> getAllEmployees() {
	        List<Employee> employees = employeeService.getAllEmployees();
	        return new ResponseEntity<>(employees, HttpStatus.OK);
	    }
	    

	 
	    @PutMapping("/{id}")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
	        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
	        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	    }

		    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
	        boolean isManager = true; 
	        if (isManager) {
	            employeeService.deleteEmployee(id);
	            return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
	        }
	    }
	    
	  
	    
	   
}
	


