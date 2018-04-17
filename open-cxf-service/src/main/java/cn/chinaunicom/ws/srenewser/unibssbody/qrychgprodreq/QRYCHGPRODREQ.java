
package cn.chinaunicom.ws.srenewser.unibssbody.qrychgprodreq;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="PROVINCE_CODE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *               &lt;minLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="EPARCHY_CODE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="6"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SERIAL_NUMBER">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NET_TYPE_CODE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PRODUCT_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DISCNT_INFO" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DISCNT_CODE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="20"/>
 *                         &lt;minLength value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PARA" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PARA_ID">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="20"/>
 *                         &lt;minLength value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="PARA_VALUE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="60"/>
 *                         &lt;minLength value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "provincecode",
    "eparchycode",
    "serialnumber",
    "nettypecode",
    "productid",
    "discntinfo",
    "para"
})
@XmlRootElement(name = "QRY_CHG_PROD_REQ")
public class QRYCHGPRODREQ {

    @XmlElement(name = "PROVINCE_CODE", required = true)
    protected String provincecode;
    @XmlElement(name = "EPARCHY_CODE", required = true)
    protected String eparchycode;
    @XmlElement(name = "SERIAL_NUMBER", required = true)
    protected String serialnumber;
    @XmlElement(name = "NET_TYPE_CODE", required = true)
    protected String nettypecode;
    @XmlElement(name = "PRODUCT_ID")
    protected String productid;
    @XmlElement(name = "DISCNT_INFO")
    protected List<QRYCHGPRODREQ.DISCNTINFO> discntinfo;
    @XmlElement(name = "PARA")
    protected List<QRYCHGPRODREQ.PARA> para;

    /**
     * Gets the value of the provincecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROVINCECODE() {
        return provincecode;
    }

    /**
     * Sets the value of the provincecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROVINCECODE(String value) {
        this.provincecode = value;
    }

    /**
     * Gets the value of the eparchycode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEPARCHYCODE() {
        return eparchycode;
    }

    /**
     * Sets the value of the eparchycode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEPARCHYCODE(String value) {
        this.eparchycode = value;
    }

    /**
     * Gets the value of the serialnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERIALNUMBER() {
        return serialnumber;
    }

    /**
     * Sets the value of the serialnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERIALNUMBER(String value) {
        this.serialnumber = value;
    }

    /**
     * Gets the value of the nettypecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNETTYPECODE() {
        return nettypecode;
    }

    /**
     * Sets the value of the nettypecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNETTYPECODE(String value) {
        this.nettypecode = value;
    }

    /**
     * Gets the value of the productid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODUCTID() {
        return productid;
    }

    /**
     * Sets the value of the productid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODUCTID(String value) {
        this.productid = value;
    }

    /**
     * Gets the value of the discntinfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the discntinfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDISCNTINFO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QRYCHGPRODREQ.DISCNTINFO }
     * 
     * 
     */
    public List<QRYCHGPRODREQ.DISCNTINFO> getDISCNTINFO() {
        if (discntinfo == null) {
            discntinfo = new ArrayList<QRYCHGPRODREQ.DISCNTINFO>();
        }
        return this.discntinfo;
    }

    /**
     * Gets the value of the para property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the para property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPARA().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QRYCHGPRODREQ.PARA }
     * 
     * 
     */
    public List<QRYCHGPRODREQ.PARA> getPARA() {
        if (para == null) {
            para = new ArrayList<QRYCHGPRODREQ.PARA>();
        }
        return this.para;
    }


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
     *         &lt;element name="DISCNT_CODE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="20"/>
     *               &lt;minLength value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "discntcode"
    })
    public static class DISCNTINFO {

        @XmlElement(name = "DISCNT_CODE", required = true)
        protected String discntcode;

        /**
         * Gets the value of the discntcode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDISCNTCODE() {
            return discntcode;
        }

        /**
         * Sets the value of the discntcode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDISCNTCODE(String value) {
            this.discntcode = value;
        }

    }


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
     *         &lt;element name="PARA_ID">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="20"/>
     *               &lt;minLength value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="PARA_VALUE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="60"/>
     *               &lt;minLength value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "paraid",
        "paravalue"
    })
    public static class PARA {

        @XmlElement(name = "PARA_ID", required = true)
        protected String paraid;
        @XmlElement(name = "PARA_VALUE", required = true)
        protected String paravalue;

        /**
         * Gets the value of the paraid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPARAID() {
            return paraid;
        }

        /**
         * Sets the value of the paraid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPARAID(String value) {
            this.paraid = value;
        }

        /**
         * Gets the value of the paravalue property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPARAVALUE() {
            return paravalue;
        }

        /**
         * Sets the value of the paravalue property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPARAVALUE(String value) {
            this.paravalue = value;
        }

    }

}
