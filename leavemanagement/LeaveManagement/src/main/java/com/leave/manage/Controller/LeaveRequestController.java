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
import org.springframework.web.bind.annotation.RestController;
import com.leave.manage.Entity.LeaveRequest;
import com.leave.manage.Entity.LeaveStatus;
import com.leave.manage.Exception.CustomException;
import com.leave.manage.Repository.LeaveRequestRepository;
import com.leave.manage.Service.LeaveRequestService;

@RestController
@RequestMapping("/api/leave-requests")
public class LeaveRequestController {
	
	private final LeaveRequestService leaveRequestService;
    
    @Autowired
    private LeaveRequestRepository leaveRequestRepository;
    
    @Autowired
    public LeaveRequestController(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }
    
    
    @PostMapping("/{id}/leave-requests")
    public ResponseEntity<LeaveRequest> applyLeave(@PathVariable Long id, @RequestBody LeaveRequest leaveRequest) {
        LeaveRequest appliedLeaveRequest = leaveRequestService.applyLeave(id, leaveRequest);
        return new ResponseEntity<>(appliedLeaveRequest, HttpStatus.CREATED);
    }
    
    
    @GetMapping
    public ResponseEntity<List<LeaveRequest>> getAllLeaveRequests() {
        List<LeaveRequest> leaveRequests = leaveRequestService.getAllLeaveRequests();
        return new ResponseEntity<>(leaveRequests, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveRequest> getLeaveRequestById(@PathVariable Long id) {
        LeaveRequest leaveRequest = leaveRequestService.getLeaveRequestById(id);
        return new ResponseEntity<>(leaveRequest, HttpStatus.OK);
    }
    
    @GetMapping("/{id}/leave-requests")
    public ResponseEntity<List<LeaveRequest>> getAllLeaveRequests(@PathVariable Long id) {
        List<LeaveRequest> leaveRequests = leaveRequestService.getAllLeaveRequests(id);
        return new ResponseEntity<>(leaveRequests, HttpStatus.OK);
    }
 
    
    @PutMapping("/employees/{employeeId}/leave-requests")
    public ResponseEntity<String> updateLeaveRequests(@PathVariable Long employeeId, @RequestBody LeaveRequest leaveRequest) {
        leaveRequestService.updateLeaveRequests(employeeId, leaveRequest);
        return new ResponseEntity<>("Leave requests updated successfully for employee ID: " + employeeId, HttpStatus.OK);
    }    
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLeaveRequest(@PathVariable Long id) {
        leaveRequestService.deleteLeaveRequest(id);
        return new ResponseEntity<>("Leave request deleted successfully", HttpStatus.OK);
    }
    
    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<String> deleteAllLeaveRequestsByEmployeeId(@PathVariable Long employeeId) {
        leaveRequestService.deleteAllLeaveRequestsByEmployeeId(employeeId);
        return new ResponseEntity<>("All leave requests of the employee deleted successfully", HttpStatus.OK);
    }
    
  
    @PostMapping("/{id}/approve")
    public ResponseEntity<String> approveLeaveRequest(@PathVariable Long id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new CustomException("Leave request not found with id: " + id));
        leaveRequest.setStatus(LeaveStatus.APPROVED);
        leaveRequestRepository.save(leaveRequest);

        return new ResponseEntity<>("Leave request approved successfully", HttpStatus.OK);
    }
    
    
    @PostMapping("/{id}/reject")
    public ResponseEntity<String> rejectLeaveRequest(@PathVariable Long id) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new CustomException("Leave request not found with id: " + id));
        leaveRequest.setStatus(LeaveStatus.REJECTED);
        leaveRequestRepository.save(leaveRequest);
        return new ResponseEntity<>("Leave request rejected successfully", HttpStatus.OK);
    }
}
