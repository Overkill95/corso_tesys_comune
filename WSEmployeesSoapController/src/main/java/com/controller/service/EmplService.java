package com.controller.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;

import org.springframework.stereotype.Service;

import com.employees.service.Employee;
import com.employees.service.EmployeeService;
import com.employees.service.EmployeeServiceService;

@Service
public class EmplService {

	String endpoint = "http://localhost:8080/WSEmployeesSoap/wsemployee";
	EmployeeServiceService employeeService = new EmployeeServiceService();
	EmployeeService port = employeeService.getEmployeeServicePort();
	BindingProvider bp = (BindingProvider)port;
	
	public List <Employee> getEmployees(){
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, this.endpoint);
		return port.getEmployees();
	}
	
	
	public Employee getEmployeeById(int id) {
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, this.endpoint);
		return port.getEmployeeById(id);
	}
	
	
	public String updateEmployee(int employee_id, String first_name, String last_name, String email, String phone_number, Date hire_date, int job_id, BigDecimal salary, int manager_id, int department_id) {
	    try {
	        GregorianCalendar gregorianCalendar = new GregorianCalendar();
	        gregorianCalendar.setTime(hire_date);
	        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);

	        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, this.endpoint);
	        return port.updateEmployee(employee_id, first_name, last_name, email, phone_number, xmlGregorianCalendar, job_id, salary, manager_id, department_id);
	    } catch (DatatypeConfigurationException e) {
	        e.printStackTrace();
	        return "Error converting hire date: " + e.getMessage();
	    }
	}
	
	
	public String addEmployee(int employee_id, String first_name, String last_name, String email, String phone_number, Date hire_date, int job_id, BigDecimal salary, int manager_id, int department_id) {
	    try {
	        GregorianCalendar gregorianCalendar = new GregorianCalendar();
	        gregorianCalendar.setTime(hire_date);
	        XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);

	        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, this.endpoint);
	        return port.addEmployee(employee_id, first_name, last_name, email, phone_number, xmlGregorianCalendar, job_id, salary, manager_id, department_id);
	    } catch (DatatypeConfigurationException e) {
	        e.printStackTrace();
	        return "Error converting hire date: " + e.getMessage();
	    }
	}
	
	
    public String deleteEmployee(int employee_id) {
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, this.endpoint);
        return port.deleteEmployee(employee_id);
    }
}
