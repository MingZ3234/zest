//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-27 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.21 at 11:27:54 上午 CST 
//


package com.github.bookong.zest.core.xml.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{https://www.bookong.net/schema/zest/data}RegExpRule"/>
 *           &lt;element ref="{https://www.bookong.net/schema/zest/data}CurrentTimeRule"/>
 *           &lt;element ref="{https://www.bookong.net/schema/zest/data}FromCurrentTimeRule"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Nullable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="MustNull" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "regExpRule",
    "currentTimeRule",
    "fromCurrentTimeRule"
})
@XmlRootElement(name = "Field")
public class Field {

    @XmlElement(name = "RegExpRule")
    protected String regExpRule;
    @XmlElement(name = "CurrentTimeRule")
    protected CurrentTimeRule currentTimeRule;
    @XmlElement(name = "FromCurrentTimeRule")
    protected FromCurrentTimeRule fromCurrentTimeRule;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "Nullable")
    protected Boolean nullable;
    @XmlAttribute(name = "MustNull")
    protected Boolean mustNull;

    /**
     * Gets the value of the regExpRule property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegExpRule() {
        return regExpRule;
    }

    /**
     * Sets the value of the regExpRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegExpRule(String value) {
        this.regExpRule = value;
    }

    /**
     * Gets the value of the currentTimeRule property.
     * 
     * @return
     *     possible object is
     *     {@link CurrentTimeRule }
     *     
     */
    public CurrentTimeRule getCurrentTimeRule() {
        return currentTimeRule;
    }

    /**
     * Sets the value of the currentTimeRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrentTimeRule }
     *     
     */
    public void setCurrentTimeRule(CurrentTimeRule value) {
        this.currentTimeRule = value;
    }

    /**
     * Gets the value of the fromCurrentTimeRule property.
     * 
     * @return
     *     possible object is
     *     {@link FromCurrentTimeRule }
     *     
     */
    public FromCurrentTimeRule getFromCurrentTimeRule() {
        return fromCurrentTimeRule;
    }

    /**
     * Sets the value of the fromCurrentTimeRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link FromCurrentTimeRule }
     *     
     */
    public void setFromCurrentTimeRule(FromCurrentTimeRule value) {
        this.fromCurrentTimeRule = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the nullable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isNullable() {
        if (nullable == null) {
            return false;
        } else {
            return nullable;
        }
    }

    /**
     * Sets the value of the nullable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNullable(Boolean value) {
        this.nullable = value;
    }

    /**
     * Gets the value of the mustNull property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isMustNull() {
        if (mustNull == null) {
            return false;
        } else {
            return mustNull;
        }
    }

    /**
     * Sets the value of the mustNull property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMustNull(Boolean value) {
        this.mustNull = value;
    }

}
