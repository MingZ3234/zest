//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-27 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.08.14 at 02:03:16 下午 CST 
//


package com.github.bookong.zest.support.xml.data;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.github.bookong.zest.support.xml.data package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Value_QNAME = new QName("https://www.bookong.net/schema/zest/data", "Value");
    private final static QName _Null_QNAME = new QName("https://www.bookong.net/schema/zest/data", "Null");
    private final static QName _Description_QNAME = new QName("https://www.bookong.net/schema/zest/data", "Description");
    private final static QName _Query_QNAME = new QName("https://www.bookong.net/schema/zest/data", "Query");
    private final static QName _RegExp_QNAME = new QName("https://www.bookong.net/schema/zest/data", "RegExp");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.github.bookong.zest.support.xml.data
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ParamField }
     * 
     */
    public ParamField createParamField() {
        return new ParamField();
    }

    /**
     * Create an instance of {@link Table }
     * 
     */
    public Table createTable() {
        return new Table();
    }

    /**
     * Create an instance of {@link Row }
     * 
     */
    public Row createRow() {
        return new Row();
    }

    /**
     * Create an instance of {@link Field }
     * 
     */
    public Field createField() {
        return new Field();
    }

    /**
     * Create an instance of {@link CurrentTime }
     * 
     */
    public CurrentTime createCurrentTime() {
        return new CurrentTime();
    }

    /**
     * Create an instance of {@link FromCurrentTime }
     * 
     */
    public FromCurrentTime createFromCurrentTime() {
        return new FromCurrentTime();
    }

    /**
     * Create an instance of {@link TestParam }
     * 
     */
    public TestParam createTestParam() {
        return new TestParam();
    }

    /**
     * Create an instance of {@link Data }
     * 
     */
    public Data createData() {
        return new Data();
    }

    /**
     * Create an instance of {@link Sources }
     * 
     */
    public Sources createSources() {
        return new Sources();
    }

    /**
     * Create an instance of {@link Source }
     * 
     */
    public Source createSource() {
        return new Source();
    }

    /**
     * Create an instance of {@link Init }
     * 
     */
    public Init createInit() {
        return new Init();
    }

    /**
     * Create an instance of {@link Target }
     * 
     */
    public Target createTarget() {
        return new Target();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://www.bookong.net/schema/zest/data", name = "Value")
    public JAXBElement<String> createValue(String value) {
        return new JAXBElement<String>(_Value_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://www.bookong.net/schema/zest/data", name = "Null")
    public JAXBElement<String> createNull(String value) {
        return new JAXBElement<String>(_Null_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://www.bookong.net/schema/zest/data", name = "Description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://www.bookong.net/schema/zest/data", name = "Query")
    public JAXBElement<String> createQuery(String value) {
        return new JAXBElement<String>(_Query_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://www.bookong.net/schema/zest/data", name = "RegExp")
    public JAXBElement<String> createRegExp(String value) {
        return new JAXBElement<String>(_RegExp_QNAME, String.class, null, value);
    }

}
