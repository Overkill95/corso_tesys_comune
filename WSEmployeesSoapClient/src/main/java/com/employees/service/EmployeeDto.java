
package com.employees.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per employeeDto complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="employeeDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="departmentId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="employeeId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hireDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="jobId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="managerId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="salary" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "employeeDto", propOrder = {
    "departmentId",
    "email",
    "employeeId",
    "firstName",
    "hireDate",
    "jobId",
    "lastName",
    "managerId",
    "phoneNumber",
    "salary"
})
public class EmployeeDto {

    protected Integer departmentId;
    protected String email;
    protected Integer employeeId;
    protected String firstName;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar hireDate;
    protected Integer jobId;
    protected String lastName;
    protected Integer managerId;
    protected String phoneNumber;
    protected double salary;

    /**
     * Recupera il valore della proprietà departmentId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * Imposta il valore della proprietà departmentId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDepartmentId(Integer value) {
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
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * Imposta il valore della proprietà employeeId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEmployeeId(Integer value) {
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
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getJobId() {
        return jobId;
    }

    /**
     * Imposta il valore della proprietà jobId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setJobId(Integer value) {
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
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getManagerId() {
        return managerId;
    }

    /**
     * Imposta il valore della proprietà managerId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setManagerId(Integer value) {
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
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Imposta il valore della proprietà salary.
     * 
     */
    public void setSalary(double value) {
        this.salary = value;
    }

}
