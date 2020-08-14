//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-27 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.08.14 at 02:03:16 下午 CST 
//


package com.github.bookong.zest.support.xml.data;

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
 *         &lt;element ref="{https://www.bookong.net/schema/zest/data}Description" minOccurs="0"/>
 *         &lt;element ref="{https://www.bookong.net/schema/zest/data}Sources"/>
 *         &lt;element ref="{https://www.bookong.net/schema/zest/data}TestParam"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Version" type="{http://www.w3.org/2001/XMLSchema}float" default="1.0" />
 *       &lt;attribute name="currentTime" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "description",
    "sources",
    "testParam"
})
@XmlRootElement(name = "Data")
public class Data {

    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Sources", required = true)
    protected Sources sources;
    @XmlElement(name = "TestParam", required = true)
    protected TestParam testParam;
    @XmlAttribute(name = "Version")
    protected Float version;
    @XmlAttribute(name = "currentTime")
    protected String currentTime;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the sources property.
     * 
     * @return
     *     possible object is
     *     {@link Sources }
     *     
     */
    public Sources getSources() {
        return sources;
    }

    /**
     * Sets the value of the sources property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sources }
     *     
     */
    public void setSources(Sources value) {
        this.sources = value;
    }

    /**
     * Gets the value of the testParam property.
     * 
     * @return
     *     possible object is
     *     {@link TestParam }
     *     
     */
    public TestParam getTestParam() {
        return testParam;
    }

    /**
     * Sets the value of the testParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link TestParam }
     *     
     */
    public void setTestParam(TestParam value) {
        this.testParam = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public float getVersion() {
        if (version == null) {
            return  1.0F;
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setVersion(Float value) {
        this.version = value;
    }

    /**
     * Gets the value of the currentTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentTime() {
        return currentTime;
    }

    /**
     * Sets the value of the currentTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentTime(String value) {
        this.currentTime = value;
    }

}
