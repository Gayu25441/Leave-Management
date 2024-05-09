package com.leave.manage.Service;
import java.util.List;
import com.leave.manage.Entity.LeaveRequest;

     public interface LeaveRequestService {
    	 
    	 LeaveRequest applyLeave(Long id, LeaveRequest leaveRequest);
    	 List<LeaveRequest> getAllLeaveRequests();
         LeaveRequest getLeaveRequestById(Long id);
         List<LeaveRequest> getAllLeaveRequests(Long id);
         void updateLeaveRequests(Long employeeId, LeaveRequest leaveRequest);
         void deleteLeaveRequest(Long id);
         void deleteAllLeaveRequestsByEmployeeId(Long employeeId);
         void approveLeaveRequest(Long id);
         void rejectLeaveRequest(Long id);
}