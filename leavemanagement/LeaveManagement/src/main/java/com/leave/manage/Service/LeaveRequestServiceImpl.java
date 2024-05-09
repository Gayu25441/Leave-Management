package com.leave.manage.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leave.manage.Entity.Employee;
import com.leave.manage.Entity.LeaveRequest;
import com.leave.manage.Entity.LeaveStatus;
import com.leave.manage.Exception.CustomException;
import com.leave.manage.Repository.EmployeeRepository;
import com.leave.manage.Repository.LeaveRequestRepository;


@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {
	
	 @Autowired
    private  LeaveRequestRepository leaveRequestRepository;
	 @Autowired
	 private EmployeeRepository employeeRepository;
	 
	 @Override
	 public LeaveRequest applyLeave(Long employeeId, LeaveRequest leaveRequest) {
	     Employee employee = employeeRepository.findById(employeeId)
	             .orElseThrow(() -> new CustomException("Employee not found with id: " + employeeId));
	     leaveRequest.setEmployee(employee);
	     return leaveRequestRepository.save(leaveRequest);
	 }
	 
	    @Override
	    public List<LeaveRequest> getAllLeaveRequests() {
	        return leaveRequestRepository.findAll();
	    }
	    

	    @Override
	    public LeaveRequest getLeaveRequestById(Long id) {
	        return leaveRequestRepository.findById(id)
	                .orElseThrow(() -> new CustomException("Leave request not found with id: " + id));
	    }

    
	    @Override
		public List<LeaveRequest> getAllLeaveRequests(Long id) {
			List<LeaveRequest> leaveRequests = leaveRequestRepository.findAllByEmployeeId(id);
			return leaveRequests;
		}
    

	    @Override
	    public void updateLeaveRequests(Long employeeId, LeaveRequest leaveRequest) {
	        List<LeaveRequest> leaveRequests = leaveRequestRepository.findByEmployeeId(employeeId);
	        for (LeaveRequest request : leaveRequests) {
	        	request.setEmployee(leaveRequest.getEmployee());
	            request.setStartDate(leaveRequest.getStartDate());
	            request.setEndDate(leaveRequest.getEndDate());
	            request.setDescription(leaveRequest.getDescription());
	            request.setLeaveType(leaveRequest.getLeaveType());
	            request.setNumberOfDays(leaveRequest.getNumberOfDays());
	            request.setStatus(leaveRequest.getStatus());
	            request.setRemainingDaysLeaveLeft(leaveRequest.getRemainingDaysLeaveLeft());
	            leaveRequestRepository.save(request);
	        }
	    }

   
	    @Override
	    public void deleteLeaveRequest(Long id) {
	        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
	                .orElseThrow(() -> new CustomException("Leave request not found with id: " + id));
	        leaveRequestRepository.delete(leaveRequest);
	    }
    
    
	    @Override
	    public void deleteAllLeaveRequestsByEmployeeId(Long employeeId) {
	        List<LeaveRequest> leaveRequests = leaveRequestRepository.findByEmployeeId(employeeId);
	        leaveRequestRepository.deleteAll(leaveRequests);
	    }
    
	    @Override
	    public void approveLeaveRequest(Long id) {
	        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
	                .orElseThrow(() -> new CustomException("Leave request not found with id: " + id));
	        if (!leaveRequest.getEmployee().getRole().equals("MANAGER")) {
	            throw new CustomException("Only managers can approve leave requests");
	        }
	        leaveRequest.setStatus(LeaveStatus.APPROVED);
	        leaveRequestRepository.save(leaveRequest);   
	    }

	    @Override
	    public void rejectLeaveRequest(Long id) {
	        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
	                .orElseThrow(() -> new CustomException("Leave request not found with id: " + id));
	        if (!leaveRequest.getEmployee().getRole().equals("MANAGER")) {
	            throw new CustomException("Only managers can reject leave requests");
	        }
	        leaveRequest.setStatus(LeaveStatus.REJECTED);
	        leaveRequestRepository.save(leaveRequest);
	    }
	}
    
 
