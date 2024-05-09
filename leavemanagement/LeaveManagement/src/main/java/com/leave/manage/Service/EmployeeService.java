package com.leave.manage.Service;

import java.util.List;

import com.leave.manage.Entity.Employee;
import com.leave.manage.Entity.Role;

public interface EmployeeService {
	
		public Employee register(Employee employee);
	    public Employee login(String username, String password);
	    public Employee getEmployeeById(Long id);
	    List<Employee> getAllEmployees();
	    public Employee updateEmployee(Long id, Employee employee);
	    public void deleteEmployee(Long id);
	    Role getUserRole(String username, String password);
		}
