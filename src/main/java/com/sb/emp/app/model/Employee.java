package com.sb.emp.app.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "employees")
public class Employee {

    private long id;

    @NotNull
    private String name;
 
    @NotNull
    @CreationTimestamp
    private LocalDate dob;
    
    @NotNull
    private String designation;
    
    @NotNull
    @Min(value = 1, message = "Salary can't be less than 1 or bigger than 999999")
    @Max(999999)
    private double salary;
    
    private String address;
    
    private String bloodGrp;

    public Employee() {

    }

    
    public Employee(@NotNull String name, @NotNull LocalDate  dob, @NotNull String designation, @NotNull double salary,
			String address, String bloodGrp) {
		super();
		this.name = name;
		this.dob = dob;
		this.designation = designation;
		this.salary = salary;
		this.address = address;
		this.bloodGrp = bloodGrp;
	}



	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


	@Column(name = "dob", nullable = false)
	public LocalDate  getDob() {
		return dob;
	}



	public void setDob(LocalDate  dob) {
		this.dob = dob;
	}


	@Column(name = "designation", nullable = false)
	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}


	@Column(name = "salary", nullable = false)
	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getBloodGrp() {
		return bloodGrp;
	}



	public void setBloodGrp(String bloodGrp) {
		this.bloodGrp = bloodGrp;
	}
    
    

	/*
	 * @Column(name = "name", nullable = false) public String getFirstName() {
	 * return firstName; }
	 * 
	 * public void setFirstName(String firstName) { this.firstName = firstName; }
	 * 
	 * @Column(name = "last_name", nullable = false) public String getLastName() {
	 * return lastName; }
	 * 
	 * public void setLastName(String lastName) { this.lastName = lastName; }
	 * 
	 * @Column(name = "email_address", nullable = false) public String getEmailId()
	 * { return emailId; }
	 * 
	 * public void setEmailId(String emailId) { this.emailId = emailId; }
	 * 
	 * @Column(name = "passport_number", nullable = false) public String
	 * getPassportNumber() { return passportNumber; }
	 * 
	 * public void setPassportNumber(String passportNumber) { this.passportNumber =
	 * passportNumber; }
	 */

}
