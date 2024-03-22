
package com.employees.service;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per updateEmployee complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="updateEmployee">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="arg1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arg2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arg3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arg4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arg5" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="arg6" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="arg7" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="arg8" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="arg9" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateEmployee", propOrder = {
    "arg0",
    "arg1",
    "arg2",
    "arg3",
    "arg4",
    "arg5",
    "arg6",
    "arg7",
    "arg8",
    "arg9"
})
public class UpdateEmployee {

    protected int arg0;
    protected String arg1;
    protected String arg2;
    protected String arg3;
    protected String arg4;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar arg5;
    protected int arg6;
    protected BigDecimal arg7;
    protected int arg8;
    protected int arg9;

    /**
     * Recupera il valore della proprietà arg0.
     * 
     */
    public int getArg0() {
        return arg0;
    }

    /**
     * Imposta il valore della proprietà arg0.
     * 
     */
    public void setArg0(int value) {
        this.arg0 = value;
    }

    /**
     * Recupera il valore della proprietà arg1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArg1() {
        return arg1;
    }

    /**
     * Imposta il valore della proprietà arg1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArg1(String value) {
        this.arg1 = value;
    }

    /**
     * Recupera il valore della proprietà arg2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArg2() {
        return arg2;
    }

    /**
     * Imposta il valore della proprietà arg2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArg2(String value) {
        this.arg2 = value;
    }

    /**
     * Recupera il valore della proprietà arg3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArg3() {
        return arg3;
    }

    /**
     * Imposta il valore della proprietà arg3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArg3(String value) {
        this.arg3 = value;
    }

    /**
     * Recupera il valore della proprietà arg4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArg4() {
        return arg4;
    }

    /**
     * Imposta il valore della proprietà arg4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArg4(String value) {
        this.arg4 = value;
    }

    /**
     * Recupera il valore della proprietà arg5.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getArg5() {
        return arg5;
    }

    /**
     * Imposta il valore della proprietà arg5.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setArg5(XMLGregorianCalendar value) {
        this.arg5 = value;
    }

    /**
     * Recupera il valore della proprietà arg6.
     * 
     */
    public int getArg6() {
        return arg6;
    }

    /**
     * Imposta il valore della proprietà arg6.
     * 
     */
    public void setArg6(int value) {
        this.arg6 = value;
    }

    /**
     * Recupera il valore della proprietà arg7.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getArg7() {
        return arg7;
    }

    /**
     * Imposta il valore della proprietà arg7.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setArg7(BigDecimal value) {
        this.arg7 = value;
    }

    /**
     * Recupera il valore della proprietà arg8.
     * 
     */
    public int getArg8() {
        return arg8;
    }

    /**
     * Imposta il valore della proprietà arg8.
     * 
     */
    public void setArg8(int value) {
        this.arg8 = value;
    }

    /**
     * Recupera il valore della proprietà arg9.
     * 
     */
    public int getArg9() {
        return arg9;
    }

    /**
     * Imposta il valore della proprietà arg9.
     * 
     */
    public void setArg9(int value) {
        this.arg9 = value;
    }

}
