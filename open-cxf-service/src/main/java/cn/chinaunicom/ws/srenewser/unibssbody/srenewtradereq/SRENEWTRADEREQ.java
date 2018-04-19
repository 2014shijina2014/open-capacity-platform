
package cn.chinaunicom.ws.srenewser.unibssbody.srenewtradereq;

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
 *         &lt;element name="OPER_ID">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CHANNEL_ID">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
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
 *         &lt;element name="TRADE_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SUBSCRIBE_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TRADE_TYPE_CODE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *               &lt;minLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IN_MODE_CODE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="E_IN_MODE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="USER_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="16"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CUST_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="16"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ACCT_ID" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="16"/>
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
 *         &lt;element name="ACCEPT_DATE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="14"/>
 *               &lt;minLength value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CHANGE_TAG">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
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
    "operid",
    "channelid",
    "provincecode",
    "eparchycode",
    "tradeid",
    "subscribeid",
    "tradetypecode",
    "inmodecode",
    "einmode",
    "userid",
    "custid",
    "acctid",
    "serialnumber",
    "nettypecode",
    "acceptdate",
    "changetag",
    "para"
})
@XmlRootElement(name = "SRENEW_TRADE_REQ")
public class SRENEWTRADEREQ {

    @XmlElement(name = "OPER_ID", required = true)
    protected String operid;
    @XmlElement(name = "CHANNEL_ID", required = true)
    protected String channelid;
    @XmlElement(name = "PROVINCE_CODE", required = true)
    protected String provincecode;
    @XmlElement(name = "EPARCHY_CODE", required = true)
    protected String eparchycode;
    @XmlElement(name = "TRADE_ID")
    protected String tradeid;
    @XmlElement(name = "SUBSCRIBE_ID")
    protected String subscribeid;
    @XmlElement(name = "TRADE_TYPE_CODE", required = true)
    protected String tradetypecode;
    @XmlElement(name = "IN_MODE_CODE", required = true)
    protected String inmodecode;
    @XmlElement(name = "E_IN_MODE", required = true)
    protected String einmode;
    @XmlElement(name = "USER_ID")
    protected String userid;
    @XmlElement(name = "CUST_ID")
    protected String custid;
    @XmlElement(name = "ACCT_ID")
    protected String acctid;
    @XmlElement(name = "SERIAL_NUMBER", required = true)
    protected String serialnumber;
    @XmlElement(name = "NET_TYPE_CODE", required = true)
    protected String nettypecode;
    @XmlElement(name = "ACCEPT_DATE", required = true)
    protected String acceptdate;
    @XmlElement(name = "CHANGE_TAG", required = true)
    protected String changetag;
    @XmlElement(name = "PARA")
    protected List<SRENEWTRADEREQ.PARA> para;

    /**
     * Gets the value of the operid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOPERID() {
        return operid;
    }

    /**
     * Sets the value of the operid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOPERID(String value) {
        this.operid = value;
    }

    /**
     * Gets the value of the channelid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHANNELID() {
        return channelid;
    }

    /**
     * Sets the value of the channelid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHANNELID(String value) {
        this.channelid = value;
    }

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
     * Gets the value of the tradeid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRADEID() {
        return tradeid;
    }

    /**
     * Sets the value of the tradeid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRADEID(String value) {
        this.tradeid = value;
    }

    /**
     * Gets the value of the subscribeid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUBSCRIBEID() {
        return subscribeid;
    }

    /**
     * Sets the value of the subscribeid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUBSCRIBEID(String value) {
        this.subscribeid = value;
    }

    /**
     * Gets the value of the tradetypecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRADETYPECODE() {
        return tradetypecode;
    }

    /**
     * Sets the value of the tradetypecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRADETYPECODE(String value) {
        this.tradetypecode = value;
    }

    /**
     * Gets the value of the inmodecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINMODECODE() {
        return inmodecode;
    }

    /**
     * Sets the value of the inmodecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINMODECODE(String value) {
        this.inmodecode = value;
    }

    /**
     * Gets the value of the einmode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEINMODE() {
        return einmode;
    }

    /**
     * Sets the value of the einmode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEINMODE(String value) {
        this.einmode = value;
    }

    /**
     * Gets the value of the userid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERID() {
        return userid;
    }

    /**
     * Sets the value of the userid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERID(String value) {
        this.userid = value;
    }

    /**
     * Gets the value of the custid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTID() {
        return custid;
    }

    /**
     * Sets the value of the custid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTID(String value) {
        this.custid = value;
    }

    /**
     * Gets the value of the acctid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCTID() {
        return acctid;
    }

    /**
     * Sets the value of the acctid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCTID(String value) {
        this.acctid = value;
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
     * Gets the value of the acceptdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCEPTDATE() {
        return acceptdate;
    }

    /**
     * Sets the value of the acceptdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCEPTDATE(String value) {
        this.acceptdate = value;
    }

    /**
     * Gets the value of the changetag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHANGETAG() {
        return changetag;
    }

    /**
     * Sets the value of the changetag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHANGETAG(String value) {
        this.changetag = value;
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
     * {@link SRENEWTRADEREQ.PARA }
     * 
     * 
     */
    public List<SRENEWTRADEREQ.PARA> getPARA() {
        if (para == null) {
            para = new ArrayList<SRENEWTRADEREQ.PARA>();
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
