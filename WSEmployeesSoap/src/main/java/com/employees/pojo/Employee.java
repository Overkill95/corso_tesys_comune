package com.employees.pojo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;



@Entity
@Table(name = "employees_Daniel")
public class Employee {

	  	@Id
	  	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "employee_id")
	    private Integer employeeId;// Devono avere lo stesso nome del body del json
	    
	    @Column(name = "first_name")
	    private String firstName;
	       
	    @Column(name = "last_name")
	    private String lastName;
	    
	    @Column(name = "email")
	    private String email;
	  
	    @Column(name = "phone_number")
	    private String phoneNumber;

	    @Column(name = "hire_date")
	    @Temporal(TemporalType.DATE)
	    private Date hireDate;
	    
	    @Column(name = "job_id")
	    private Integer jobId;
	 
	    @Column(name = "salary")
	    private double salary;
	    
	    @Column(name = "manager_id")
	    private Integer managerId;
	    
	    @Column(name = "department_id")
	    private Integer departmentId;
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "Username", referencedColumnName = "username")
	    private User username;
	    

    

	public User getUsername() {
			return username;
		}

		public void setUsername(User username) {
			this.username = username;
		}

	public Employee(Integer employeeId, String firstName, String lastName, String email, String phoneNumber,
                    Date hireDate,Integer jobId, double salary, Integer managerId, Integer departmentId) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.salary = salary;
        this.managerId = managerId;
        this.departmentId = departmentId;
    }
    
    public Employee() {
       
    }
    

    
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
    
//    public String getFormattedHireDate() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        return hireDate.format(formatter);
//    }

  
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", jobId='" + jobId + '\'' +
                ", salary=" + salary +
                ", managerId=" + managerId +
                ", departmentId=" + departmentId +
                '}';
    }
}

