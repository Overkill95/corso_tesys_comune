package com.employees.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.NamingException;
import javax.xml.ws.WebServiceException;

import com.employees.connector.DatabaseConnector;
import com.employees.pojo.Employee;

@WebService
public class EmployeeService {
	

    @WebMethod
    public List<Employee> getEmployees() throws WebServiceException{
    	List<Employee> employees = new ArrayList<Employee>();
    	try (Connection connection = DatabaseConnector.getConnection()) {
        	PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees");
        	ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	java.sql.Date sqlHireDate = resultSet.getDate("hire_date");
                java.util.Date utilHireDate = new java.util.Date(sqlHireDate.getTime());
            	
                Employee e = new Employee(
                			resultSet.getInt("employee_id"),
                			resultSet.getString("first_name"),
                			resultSet.getString("last_name"),
                			resultSet.getString("email"),
                			resultSet.getString("phone_number"),
                			utilHireDate,
                            resultSet.getInt("job_id"),
                            resultSet.getBigDecimal("salary"),
                            resultSet.getInt("manager_id"),
                            resultSet.getInt("department_id")
                		);
                employees.add(e);
            }
            return employees;
            
        } catch (SQLException e) {
            e.printStackTrace();
    	} catch (NamingException e1) {
			e1.printStackTrace();
		}
		return employees;
    }
    
    @WebMethod
    public Employee getEmployeeById(int id) {
    	try (Connection connection = DatabaseConnector.getConnection()) {
        	PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees WHERE employee_id = ?");
        	preparedStatement.setInt(1, id);
        	ResultSet resultSet = preparedStatement.executeQuery();
        	
        	if(resultSet.next()) {
            	java.sql.Date sqlHireDate = resultSet.getDate("hire_date");
                java.util.Date utilHireDate = new java.util.Date(sqlHireDate.getTime());
                
        		return new Employee(
            			resultSet.getInt("employee_id"),
            			resultSet.getString("first_name"),
            			resultSet.getString("last_name"),
            			resultSet.getString("email"),
            			resultSet.getString("phone_number"),
            			utilHireDate,
                        resultSet.getInt("job_id"),
                        resultSet.getBigDecimal("salary"),
                        resultSet.getInt("manager_id"),
                        resultSet.getInt("department_id")
               );
        	}
    	}
    	catch(SQLException | NamingException e) {
    		e.printStackTrace();
    	}
		return null;
    }
    
    
    @WebMethod
    public String updateEmployee(int employee_id, String first_name, String last_name, String email, String phone_number, Date hire_date, int job_id, BigDecimal salary, int manager_id, int department_id) {
    	try (Connection connection = DatabaseConnector.getConnection()) {
        	PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employees SET first_name = ?, last_name = ?, email = ?, phone_number = ?, hire_date = ?, job_id = ?, salary = ?, manager_id = ?, department_id = ? WHERE employee_id = ?");
        	
        	preparedStatement.setString(1, first_name);
        	preparedStatement.setString(2, last_name);
        	preparedStatement.setString(3, email);
        	preparedStatement.setString(4, phone_number);
            if (hire_date != null) {
                java.sql.Date sqlHireDate = new java.sql.Date(hire_date.getTime());
                preparedStatement.setDate(5, sqlHireDate);
            } else {
                preparedStatement.setNull(5, java.sql.Types.DATE);
            }
            preparedStatement.setInt(6, job_id);
        	preparedStatement.setBigDecimal(7, salary);
        	preparedStatement.setInt(8, manager_id);
        	preparedStatement.setInt(9, department_id);
        	preparedStatement.setInt(10, employee_id);
        	
        	int affectedRows = preparedStatement.executeUpdate();
        	if(affectedRows > 0) {
        		return "Employee with ID " + employee_id + " was successfully updated.";
        	}
        	else {
            	return "No Employee found with ID " + employee_id + ".";
        	}
        }
    	catch(SQLException | NamingException e) {
    		e.printStackTrace();
    		return "Error occurred while updating Employee with ID " + employee_id + ": " + e.getMessage();
    	}
    }
    
    
    @WebMethod
    public String addEmployee(int employee_id, String first_name, String last_name, String email, String phone_number, Date hire_date, int job_id, BigDecimal salary, int manager_id, int department_id) throws WebServiceException {
    	try (Connection connection = DatabaseConnector.getConnection()) {
        	PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, manager_id, department_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        	
        	preparedStatement.setInt(1, employee_id);
        	preparedStatement.setString(2, first_name);
        	preparedStatement.setString(3, last_name);
        	preparedStatement.setString(4, email);
        	preparedStatement.setString(5, phone_number);
            if (hire_date != null) {
                java.sql.Date sqlHireDate = new java.sql.Date(hire_date.getTime());
                preparedStatement.setDate(6, sqlHireDate);
            } else {
                preparedStatement.setNull(6, java.sql.Types.DATE);
            }
        	preparedStatement.setInt(7, job_id);
        	preparedStatement.setBigDecimal(8, salary);
        	preparedStatement.setInt(9, manager_id);
        	preparedStatement.setInt(10, department_id);
        	
        	int affectedRows = preparedStatement.executeUpdate();
        	if(affectedRows > 0) {
        		return "Employee with ID " + employee_id + " was successfully created.";
        	}
        	else {
            	return "Error while creating Employee";
        	}
        }
    	catch(SQLException | NamingException e) {
    		e.printStackTrace();
    		return "Error occurred while creating Employee: " + e.getMessage();
    	}
    }
    
    
    @WebMethod
    public String deleteEmployee(int employee_id) throws WebServiceException {
    	try (Connection connection = DatabaseConnector.getConnection()) {
        	PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employees WHERE employees.employee_id = ?");
        	preparedStatement.setInt(1, employee_id);
        	int affectedRows = preparedStatement.executeUpdate();
        	
        	if(affectedRows > 0) {
        		return "Employee with ID " + employee_id + " successfully deleted.";
        	}
        	else {
        		return "No Employee found with ID " + employee_id + ".";
        	}
        }
    	catch(SQLException | NamingException e) {
    		e.printStackTrace();
    		return "Error while deleting Employee with ID " + employee_id + ": " + e.getMessage();
    	}
    }
    
    
}
