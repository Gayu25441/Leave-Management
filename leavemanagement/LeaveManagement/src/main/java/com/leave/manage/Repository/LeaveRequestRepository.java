package com.leave.manage.Repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.leave.manage.Entity.LeaveRequest;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
	List<LeaveRequest> findAllByEmployeeId(Long employeeId);
	List<LeaveRequest> findByEmployeeId(Long employeeId);
	Optional<LeaveRequest> findByIdAndEmployeeId(@Param("leaveRequestId") Long leaveRequestId, @Param("employeeId") Long employeeId);
}
