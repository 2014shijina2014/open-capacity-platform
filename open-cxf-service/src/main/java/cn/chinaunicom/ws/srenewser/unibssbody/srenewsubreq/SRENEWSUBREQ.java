
package cn.chinaunicom.ws.srenewser.unibssbody.srenewsubreq;

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
 *         &lt;element name="TRADE_ID">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SUBSCRIBE_ID">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
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
 *         &lt;element name="FEE_INFO" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="OPERATE_TYPE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="1"/>
 *                         &lt;minLength value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="FEE_MODE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="1"/>
 *                         &lt;minLength value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="FEE_TYPE_CODE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="8"/>
 *                         &lt;minLength value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="FEE_TYPE_NAME">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="50"/>
 *                         &lt;minLength value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="OLD_FEE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="11"/>
 *                         &lt;minLength value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="DERATE_FEE" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="11"/>
 *                         &lt;minLength value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="DERATE_REMARK" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="100"/>
 *                         &lt;minLength value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="FEE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="11"/>
 *                         &lt;minLength value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="PAY_TAG">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="1"/>
 *                         &lt;minLength value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CALCULATE_TAG">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="1"/>
 *                         &lt;minLength value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CALCULATE_ID" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="30"/>
 *                         &lt;minLength value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CALCULATE_DATE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="14"/>
 *                         &lt;minLength value="14"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PAY_INFO" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PAY_TYPE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="2"/>
 *                         &lt;minLength value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="PAY_MONEY">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="11"/>
 *                         &lt;minLength value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="TOTAL_FEE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="11"/>
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
    "operid",
    "channelid",
    "provincecode",
    "eparchycode",
    "tradeid",
    "subscribeid",
    "acceptdate",
    "feeinfo",
    "payinfo",
    "para"
})
@XmlRootElement(name = "SRENEW_SUB_REQ")
public class SRENEWSUBREQ {

    @XmlElement(name = "OPER_ID", required = true)
    protected String operid;
    @XmlElement(name = "CHANNEL_ID", required = true)
    protected String channelid;
    @XmlElement(name = "PROVINCE_CODE", required = true)
    protected String provincecode;
    @XmlElement(name = "EPARCHY_CODE", required = true)
    protected String eparchycode;
    @XmlElement(name = "TRADE_ID", required = true)
    protected String tradeid;
    @XmlElement(name = "SUBSCRIBE_ID", required = true)
    protected String subscribeid;
    @XmlElement(name = "ACCEPT_DATE", required = true)
    protected String acceptdate;
    @XmlElement(name = "FEE_INFO", required = true)
    protected List<SRENEWSUBREQ.FEEINFO> feeinfo;
    @XmlElement(name = "PAY_INFO", required = true)
    protected List<SRENEWSUBREQ.PAYINFO> payinfo;
    @XmlElement(name = "PARA")
    protected List<SRENEWSUBREQ.PARA> para;

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
     * Gets the value of the feeinfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feeinfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFEEINFO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SRENEWSUBREQ.FEEINFO }
     * 
     * 
     */
    public List<SRENEWSUBREQ.FEEINFO> getFEEINFO() {
        if (feeinfo == null) {
            feeinfo = new ArrayList<SRENEWSUBREQ.FEEINFO>();
        }
        return this.feeinfo;
    }

    /**
     * Gets the value of the payinfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the payinfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPAYINFO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SRENEWSUBREQ.PAYINFO }
     * 
     * 
     */
    public List<SRENEWSUBREQ.PAYINFO> getPAYINFO() {
        if (payinfo == null) {
            payinfo = new ArrayList<SRENEWSUBREQ.PAYINFO>();
        }
        return this.payinfo;
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
     * {@link SRENEWSUBREQ.PARA }
     * 
     * 
     */
    public List<SRENEWSUBREQ.PARA> getPARA() {
        if (para == null) {
            para = new ArrayList<SRENEWSUBREQ.PARA>();
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
     *         &lt;element name="OPERATE_TYPE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="1"/>
     *               &lt;minLength value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="FEE_MODE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="1"/>
     *               &lt;minLength value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="FEE_TYPE_CODE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="8"/>
     *               &lt;minLength value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="FEE_TYPE_NAME">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="50"/>
     *               &lt;minLength value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="OLD_FEE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="11"/>
     *               &lt;minLength value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DERATE_FEE" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="11"/>
     *               &lt;minLength value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DERATE_REMARK" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="100"/>
     *               &lt;minLength value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="FEE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="11"/>
     *               &lt;minLength value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="PAY_TAG">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="1"/>
     *               &lt;minLength value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CALCULATE_TAG">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="1"/>
     *               &lt;minLength value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CALCULATE_ID" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="30"/>
     *               &lt;minLength value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CALCULATE_DATE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="14"/>
     *               &lt;minLength value="14"/>
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
        "operatetype",
        "feemode",
        "feetypecode",
        "feetypename",
        "oldfee",
        "deratefee",
        "derateremark",
        "fee",
        "paytag",
        "calculatetag",
        "calculateid",
        "calculatedate"
    })
    public static class FEEINFO {

        @XmlElement(name = "OPERATE_TYPE", required = true)
        protected String operatetype;
        @XmlElement(name = "FEE_MODE", required = true)
        protected String feemode;
        @XmlElement(name = "FEE_TYPE_CODE", required = true)
        protected String feetypecode;
        @XmlElement(name = "FEE_TYPE_NAME", required = true)
        protected String feetypename;
        @XmlElement(name = "OLD_FEE", required = true)
        protected String oldfee;
        @XmlElement(name = "DERATE_FEE")
        protected String deratefee;
        @XmlElement(name = "DERATE_REMARK")
        protected String derateremark;
        @XmlElement(name = "FEE", required = true)
        protected String fee;
        @XmlElement(name = "PAY_TAG", required = true)
        protected String paytag;
        @XmlElement(name = "CALCULATE_TAG", required = true)
        protected String calculatetag;
        @XmlElement(name = "CALCULATE_ID")
        protected String calculateid;
        @XmlElement(name = "CALCULATE_DATE", required = true)
        protected String calculatedate;

        /**
         * Gets the value of the operatetype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOPERATETYPE() {
            return operatetype;
        }

        /**
         * Sets the value of the operatetype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOPERATETYPE(String value) {
            this.operatetype = value;
        }

        /**
         * Gets the value of the feemode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFEEMODE() {
            return feemode;
        }

        /**
         * Sets the value of the feemode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFEEMODE(String value) {
            this.feemode = value;
        }

        /**
         * Gets the value of the feetypecode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFEETYPECODE() {
            return feetypecode;
        }

        /**
         * Sets the value of the feetypecode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFEETYPECODE(String value) {
            this.feetypecode = value;
        }

        /**
         * Gets the value of the feetypename property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFEETYPENAME() {
            return feetypename;
        }

        /**
         * Sets the value of the feetypename property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFEETYPENAME(String value) {
            this.feetypename = value;
        }

        /**
         * Gets the value of the oldfee property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOLDFEE() {
            return oldfee;
        }

        /**
         * Sets the value of the oldfee property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOLDFEE(String value) {
            this.oldfee = value;
        }

        /**
         * Gets the value of the deratefee property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDERATEFEE() {
            return deratefee;
        }

        /**
         * Sets the value of the deratefee property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDERATEFEE(String value) {
            this.deratefee = value;
        }

        /**
         * Gets the value of the derateremark property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDERATEREMARK() {
            return derateremark;
        }

        /**
         * Sets the value of the derateremark property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDERATEREMARK(String value) {
            this.derateremark = value;
        }

        /**
         * Gets the value of the fee property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFEE() {
            return fee;
        }

        /**
         * Sets the value of the fee property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFEE(String value) {
            this.fee = value;
        }

        /**
         * Gets the value of the paytag property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPAYTAG() {
            return paytag;
        }

        /**
         * Sets the value of the paytag property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPAYTAG(String value) {
            this.paytag = value;
        }

        /**
         * Gets the value of the calculatetag property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCALCULATETAG() {
            return calculatetag;
        }

        /**
         * Sets the value of the calculatetag property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCALCULATETAG(String value) {
            this.calculatetag = value;
        }

        /**
         * Gets the value of the calculateid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCALCULATEID() {
            return calculateid;
        }

        /**
         * Sets the value of the calculateid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCALCULATEID(String value) {
            this.calculateid = value;
        }

        /**
         * Gets the value of the calculatedate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCALCULATEDATE() {
            return calculatedate;
        }

        /**
         * Sets the value of the calculatedate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCALCULATEDATE(String value) {
            this.calculatedate = value;
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
     *         &lt;element name="PAY_TYPE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="2"/>
     *               &lt;minLength value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="PAY_MONEY">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="11"/>
     *               &lt;minLength value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="TOTAL_FEE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="11"/>
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
        "paytype",
        "paymoney",
        "totalfee"
    })
    public static class PAYINFO {

        @XmlElement(name = "PAY_TYPE", required = true)
        protected String paytype;
        @XmlElement(name = "PAY_MONEY", required = true)
        protected String paymoney;
        @XmlElement(name = "TOTAL_FEE", required = true)
        protected String totalfee;

        /**
         * Gets the value of the paytype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPAYTYPE() {
            return paytype;
        }

        /**
         * Sets the value of the paytype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPAYTYPE(String value) {
            this.paytype = value;
        }

        /**
         * Gets the value of the paymoney property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPAYMONEY() {
            return paymoney;
        }

        /**
         * Sets the value of the paymoney property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPAYMONEY(String value) {
            this.paymoney = value;
        }

        /**
         * Gets the value of the totalfee property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTOTALFEE() {
            return totalfee;
        }

        /**
         * Sets the value of the totalfee property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTOTALFEE(String value) {
            this.totalfee = value;
        }

    }

}
