package com.leave.manage.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "leaverequest")
public class LeaveRequest {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "employee_id")
	    private Employee employee;
	    
	    @Column(name="startdate")
	    private LocalDate startDate;
	    
	    @Column(name="enddate")
	    private LocalDate endDate;
	    
	    @Column(name="description")
	    private String description;
	    
	    @Enumerated(EnumType.STRING)
	    @Column(name="leaveType")
	    private LeaveType leaveType;
	    
	    @Column(name="noofdays")
	    private int numberOfDays;
	    
	    @Enumerated(EnumType.STRING)
	    @Column(name="leavestatus")
	    private LeaveStatus status;
	    
	    @Column(name="remainingdays")
	    private int remainingDaysLeaveLeft;
	    
	    
		public LeaveRequest(Long id, Employee employee, LocalDate startDate, LocalDate endDate, String description,
				LeaveType leaveType, int numberOfDays, LeaveStatus status, int remainingDaysLeaveLeft) {
			super();
			this.id = id;
			this.employee = employee;
			this.startDate = startDate;
			this.endDate = endDate;
			this.description = description;
			this.leaveType = leaveType;
			this.numberOfDays = numberOfDays;
			this.status = status;
			this.remainingDaysLeaveLeft = remainingDaysLeaveLeft;
		}
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Employee getEmployee() {
			return employee;
		}
		public void setEmployee(Employee employee) {
			this.employee = employee;
		}
		public LocalDate getStartDate() {
			return startDate;
		}
		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}
		public LocalDate getEndDate() {
			return endDate;
		}
		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public LeaveType getLeaveType() {
			return leaveType;
		}
		public void setLeaveType(LeaveType leaveType) {
			this.leaveType = leaveType;
		}
		public int getNumberOfDays() {
			return numberOfDays;
		}
		public void setNumberOfDays(int numberOfDays) {
			this.numberOfDays = numberOfDays;
		}
		public LeaveStatus getStatus() {
			return status;
		}
		public void setStatus(LeaveStatus status) {
			this.status = status;
		}
		public int getRemainingDaysLeaveLeft() {
			return remainingDaysLeaveLeft;
		}
		public void setRemainingDaysLeaveLeft(int remainingDaysLeaveLeft) {
			this.remainingDaysLeaveLeft = remainingDaysLeaveLeft;
		}
		
		@Override
		public String toString() {
			return "LeaveRequest [id=" + id + ", employee=" + employee + ", startDate=" + startDate + ", endDate="
					+ endDate + ", description=" + description + ", leaveType=" + leaveType + ", numberOfDays="
					+ numberOfDays + ", status=" + status + ", remainingDaysLeaveLeft=" + remainingDaysLeaveLeft + "]";
		}
	    
		public LeaveRequest() {
		    // Default constructor
		}


}
