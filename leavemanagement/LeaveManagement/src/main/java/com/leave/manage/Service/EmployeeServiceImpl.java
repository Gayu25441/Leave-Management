package com.leave.manage.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.leave.manage.Entity.Employee;
import com.leave.manage.Entity.Role;
import com.leave.manage.Exception.CustomException;
import com.leave.manage.Repository.EmployeeRepository;

	@Service
	public class EmployeeServiceImpl implements EmployeeService {
		
	  
	    @Autowired
	    private EmployeeRepository employeeRepository;
	    

	    @Override
	    public Employee register(Employee employee) {
	        return employeeRepository.save(employee);
	    }
	    

	    @Override
	    public Employee login(String username, String password) {
	        return employeeRepository.findByUsernameAndPassword(username, password);
	    }
	    

	    @Override
	    public Employee getEmployeeById(Long id) {
	        return employeeRepository.findById(id)
	                .orElseThrow(() -> new CustomException("Employee not found with id: " + id));
	    }

	    @Override
	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    @Override
	    public Employee updateEmployee(Long id, Employee employee) {
	        Employee existingEmployee = employeeRepository.findById(id)
	                .orElseThrow(() -> new CustomException("Employee not found with id: " + id));
	        existingEmployee.setFirstName(employee.getFirstName());
	        existingEmployee.setLastName(employee.getLastName());
	        existingEmployee.setDateOfBirth(employee.getDateOfBirth());
	        existingEmployee.setEmail(employee.getEmail());
	        existingEmployee.setAddress(employee.getAddress());
	        existingEmployee.setRole(employee.getRole());
	        existingEmployee.setMobileNumber(employee.getMobileNumber());
	        existingEmployee.setGender(employee.getGender());
	        existingEmployee.setDateOfJoining(employee.getDateOfJoining());
	        existingEmployee.setUsername(employee.getUsername());
	        existingEmployee.setPassword(employee.getPassword());
	        return employeeRepository.save(existingEmployee);
	    }

	    @Override
	    public void deleteEmployee(Long id) {
	        Employee employee = employeeRepository.findById(id)
	                .orElseThrow(() -> new CustomException("Employee not found with id: " + id));
	        
	        employeeRepository.delete(employee);
	    }
	    
	    
	    @Override
	    public Role getUserRole(String username, String password) {
	        Employee employee = employeeRepository.findByUsernameAndPassword(username, password);
	        if (employee != null) {
	            return employee.getRole();
	        } else {
	            return null;
	        }
	    }
	}
	    

