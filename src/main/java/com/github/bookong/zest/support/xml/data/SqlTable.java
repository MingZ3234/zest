//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-27 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.08.21 at 09:20:39 ���� CST 
//


package com.github.bookong.zest.support.xml.data;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{https://www.bookong.net/schema/zest/data}Sorts" minOccurs="0"/>
 *         &lt;element ref="{https://www.bookong.net/schema/zest/data}Row" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Ignore" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sorts",
    "row"
})
@XmlRootElement(name = "SqlTable")
public class SqlTable {

    @XmlElement(name = "Sorts")
    protected Sorts sorts;
    @XmlElement(name = "Row")
    protected List<Row> row;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "Ignore")
    protected Boolean ignore;

    /**
     * 
     * 	�������ֻ���� <Target> Ԫ���µ� <SqlTable> Ԫ���в���Ч��
     * 	��Ϊ��֤�ı�һ����һ�������������Ϊ�˷����Զ���֤������Ҫָ���������
     * 
     * 	This attribute is only valid in the <SqlTable> element under the <Target> element.
     *     Because the verified table is not necessarily an ordered primary key, in order to facilitate automatic verification, you need to specify the sorting rules
     * 						
     * 
     * @return
     *     possible object is
     *     {@link Sorts }
     *     
     */
    public Sorts getSorts() {
        return sorts;
    }

    /**
     * Sets the value of the sorts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sorts }
     *     
     */
    public void setSorts(Sorts value) {
        this.sorts = value;
    }

    /**
     * Gets the value of the row property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the row property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRow().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Row }
     * 
     * 
     */
    public List<Row> getRow() {
        if (row == null) {
            row = new ArrayList<Row>();
        }
        return this.row;
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
     * Gets the value of the ignore property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIgnore() {
        if (ignore == null) {
            return false;
        } else {
            return ignore;
        }
    }

    /**
     * Sets the value of the ignore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIgnore(Boolean value) {
        this.ignore = value;
    }

}
