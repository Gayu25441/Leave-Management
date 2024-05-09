package com.leave.manage.Entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(name="emp_fname")
    private String firstName;
    
	@Column(name="emp_lname")
    private String lastName;
    
    @Column(name="emp_dob")
    private LocalDate dateOfBirth;
    
    @Column(name="emp_email")
    private String email;
    
    @Column(name="emp_address")
    private String address;
    
    @Enumerated(EnumType.STRING)
    @Column(name="emp_role")
    private Role role; // Can be "employee" or "manager"
    
    @Column(name="emp_mobileno")
    private String mobileNumber;
    
    @Enumerated(EnumType.STRING)
    @Column(name="emp_gender")
    private Gender gender;
    
    @Column(name="emp_doj")
    private LocalDate dateOfJoining;

    @Column(name="emp_username")
    private String username;
    
    @Column(name="emp_password")
    private String password;
        
   
    
	public Employee(Long id, String firstName, String lastName, LocalDate dateOfBirth, String email, String address,
			Role role, String mobileNumber, Gender gender, LocalDate dateOfJoining, String username, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.address = address;
		this.role = role;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.dateOfJoining = dateOfJoining;
		this.username = username;
		this.password = password;
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", email=" + email + ", address=" + address + ", role=" + role + ", mobileNumber="
				+ mobileNumber + ", gender=" + gender + ", dateOfJoining=" + dateOfJoining + ", username=" + username
				+ ", password=" + password +  "]";
	}



	public Employee() {
	    // Default constructor
	}



}
