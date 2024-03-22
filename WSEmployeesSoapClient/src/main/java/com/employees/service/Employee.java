
package com.employees.service;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per employee complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="employee">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="department_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="employee_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="first_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="formattedHireDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hire_date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="job_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="last_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="manager_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="phone_number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="salary" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "employee", propOrder = {
    "departmentId",
    "email",
    "employeeId",
    "firstName",
    "formattedHireDate",
    "hireDate",
    "jobId",
    "lastName",
    "managerId",
    "phoneNumber",
    "salary"
})
public class Employee {

    @XmlElement(name = "department_id")
    protected int departmentId;
    protected String email;
    @XmlElement(name = "employee_id")
    protected int employeeId;
    @XmlElement(name = "first_name")
    protected String firstName;
    protected String formattedHireDate;
    @XmlElement(name = "hire_date")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar hireDate;
    @XmlElement(name = "job_id")
    protected int jobId;
    @XmlElement(name = "last_name")
    protected String lastName;
    @XmlElement(name = "manager_id")
    protected int managerId;
    @XmlElement(name = "phone_number")
    protected String phoneNumber;
    protected BigDecimal salary;

    /**
     * Recupera il valore della proprietà departmentId.
     * 
     */
    public int getDepartmentId() {
        return departmentId;
    }

    /**
     * Imposta il valore della proprietà departmentId.
     * 
     */
    public void setDepartmentId(int value) {
        this.departmentId = value;
    }

    /**
     * Recupera il valore della proprietà email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Imposta il valore della proprietà email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Recupera il valore della proprietà employeeId.
     * 
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Imposta il valore della proprietà employeeId.
     * 
     */
    public void setEmployeeId(int value) {
        this.employeeId = value;
    }

    /**
     * Recupera il valore della proprietà firstName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Imposta il valore della proprietà firstName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Recupera il valore della proprietà formattedHireDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormattedHireDate() {
        return formattedHireDate;
    }

    /**
     * Imposta il valore della proprietà formattedHireDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormattedHireDate(String value) {
        this.formattedHireDate = value;
    }

    /**
     * Recupera il valore della proprietà hireDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getHireDate() {
        return hireDate;
    }

    /**
     * Imposta il valore della proprietà hireDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setHireDate(XMLGregorianCalendar value) {
        this.hireDate = value;
    }

    /**
     * Recupera il valore della proprietà jobId.
     * 
     */
    public int getJobId() {
        return jobId;
    }

    /**
     * Imposta il valore della proprietà jobId.
     * 
     */
    public void setJobId(int value) {
        this.jobId = value;
    }

    /**
     * Recupera il valore della proprietà lastName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Imposta il valore della proprietà lastName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Recupera il valore della proprietà managerId.
     * 
     */
    public int getManagerId() {
        return managerId;
    }

    /**
     * Imposta il valore della proprietà managerId.
     * 
     */
    public void setManagerId(int value) {
        this.managerId = value;
    }

    /**
     * Recupera il valore della proprietà phoneNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Imposta il valore della proprietà phoneNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Recupera il valore della proprietà salary.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * Imposta il valore della proprietà salary.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSalary(BigDecimal value) {
        this.salary = value;
    }

}
