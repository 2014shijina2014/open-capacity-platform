
package cn.chinaunicom.ws.srenewser.unibssbody.qrychgprodrsp;

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
 *         &lt;element name="RESP_CODE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *               &lt;minLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RESP_DESC">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="500"/>
 *               &lt;minLength value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PRODUCT_INFO" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PRODUCT_ID">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="8"/>
 *                         &lt;minLength value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="PRODUCT_NAME">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="50"/>
 *                         &lt;minLength value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="PRODUCT_DESC">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="100"/>
 *                         &lt;minLength value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="PRODUCT_MODE" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="1"/>
 *                         &lt;minLength value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="DISCNT_INFO" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="DISCNT_CODE">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="8"/>
 *                                   &lt;minLength value="0"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="DISCNT_NAME">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="100"/>
 *                                   &lt;minLength value="0"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="DISCNT_DESC">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="200"/>
 *                                   &lt;minLength value="0"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="DISCNT_FEE">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="11"/>
 *                                   &lt;minLength value="0"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="START_ENABLE">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="1"/>
 *                                   &lt;minLength value="1"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="ACCESS_TYPE" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="50"/>
 *                                   &lt;minLength value="0"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="BRAND_SPEED">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="10"/>
 *                                   &lt;minLength value="0"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="BRAND_NUMBER">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="4"/>
 *                                   &lt;minLength value="0"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="EXP_MODE" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="1"/>
 *                                   &lt;minLength value="0"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="DISCNT_CODE_MONTH" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="8"/>
 *                                   &lt;minLength value="0"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="DISCNT_NAME_MONTH" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="50"/>
 *                                   &lt;minLength value="0"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="DISCNT_FEE_MONTH" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="11"/>
 *                                   &lt;minLength value="0"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="PARA" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="PARA_ID">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="20"/>
 *                                   &lt;minLength value="0"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="PARA_VALUE">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="60"/>
 *                                   &lt;minLength value="0"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
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
    "respcode",
    "respdesc",
    "productinfo"
})
@XmlRootElement(name = "QRY_CHG_PROD_RSP")
public class QRYCHGPRODRSP {

    @XmlElement(name = "RESP_CODE", required = true)
    protected String respcode;
    @XmlElement(name = "RESP_DESC", required = true)
    protected String respdesc;
    @XmlElement(name = "PRODUCT_INFO")
    protected List<QRYCHGPRODRSP.PRODUCTINFO> productinfo;

    /**
     * Gets the value of the respcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESPCODE() {
        return respcode;
    }

    /**
     * Sets the value of the respcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESPCODE(String value) {
        this.respcode = value;
    }

    /**
     * Gets the value of the respdesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESPDESC() {
        return respdesc;
    }

    /**
     * Sets the value of the respdesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESPDESC(String value) {
        this.respdesc = value;
    }

    /**
     * Gets the value of the productinfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productinfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPRODUCTINFO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QRYCHGPRODRSP.PRODUCTINFO }
     * 
     * 
     */
    public List<QRYCHGPRODRSP.PRODUCTINFO> getPRODUCTINFO() {
        if (productinfo == null) {
            productinfo = new ArrayList<QRYCHGPRODRSP.PRODUCTINFO>();
        }
        return this.productinfo;
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
     *         &lt;element name="PRODUCT_ID">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="8"/>
     *               &lt;minLength value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="PRODUCT_NAME">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="50"/>
     *               &lt;minLength value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="PRODUCT_DESC">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="100"/>
     *               &lt;minLength value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="PRODUCT_MODE" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="1"/>
     *               &lt;minLength value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="DISCNT_INFO" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="DISCNT_CODE">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="8"/>
     *                         &lt;minLength value="0"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="DISCNT_NAME">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="100"/>
     *                         &lt;minLength value="0"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="DISCNT_DESC">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="200"/>
     *                         &lt;minLength value="0"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="DISCNT_FEE">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="11"/>
     *                         &lt;minLength value="0"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="START_ENABLE">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="1"/>
     *                         &lt;minLength value="1"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="ACCESS_TYPE" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="50"/>
     *                         &lt;minLength value="0"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="BRAND_SPEED">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="10"/>
     *                         &lt;minLength value="0"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="BRAND_NUMBER">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="4"/>
     *                         &lt;minLength value="0"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="EXP_MODE" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="1"/>
     *                         &lt;minLength value="0"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="DISCNT_CODE_MONTH" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="8"/>
     *                         &lt;minLength value="0"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="DISCNT_NAME_MONTH" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="50"/>
     *                         &lt;minLength value="0"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="DISCNT_FEE_MONTH" minOccurs="0">
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
        "productid",
        "productname",
        "productdesc",
        "productmode",
        "discntinfo",
        "para"
    })
    public static class PRODUCTINFO {

        @XmlElement(name = "PRODUCT_ID", required = true)
        protected String productid;
        @XmlElement(name = "PRODUCT_NAME", required = true)
        protected String productname;
        @XmlElement(name = "PRODUCT_DESC", required = true)
        protected String productdesc;
        @XmlElement(name = "PRODUCT_MODE")
        protected String productmode;
        @XmlElement(name = "DISCNT_INFO", required = true)
        protected List<QRYCHGPRODRSP.PRODUCTINFO.DISCNTINFO> discntinfo;
        @XmlElement(name = "PARA")
        protected List<QRYCHGPRODRSP.PRODUCTINFO.PARA> para;

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
         * Gets the value of the productname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPRODUCTNAME() {
            return productname;
        }

        /**
         * Sets the value of the productname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPRODUCTNAME(String value) {
            this.productname = value;
        }

        /**
         * Gets the value of the productdesc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPRODUCTDESC() {
            return productdesc;
        }

        /**
         * Sets the value of the productdesc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPRODUCTDESC(String value) {
            this.productdesc = value;
        }

        /**
         * Gets the value of the productmode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPRODUCTMODE() {
            return productmode;
        }

        /**
         * Sets the value of the productmode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPRODUCTMODE(String value) {
            this.productmode = value;
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
         * {@link QRYCHGPRODRSP.PRODUCTINFO.DISCNTINFO }
         * 
         * 
         */
        public List<QRYCHGPRODRSP.PRODUCTINFO.DISCNTINFO> getDISCNTINFO() {
            if (discntinfo == null) {
                discntinfo = new ArrayList<QRYCHGPRODRSP.PRODUCTINFO.DISCNTINFO>();
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
         * {@link QRYCHGPRODRSP.PRODUCTINFO.PARA }
         * 
         * 
         */
        public List<QRYCHGPRODRSP.PRODUCTINFO.PARA> getPARA() {
            if (para == null) {
                para = new ArrayList<QRYCHGPRODRSP.PRODUCTINFO.PARA>();
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
         *               &lt;maxLength value="8"/>
         *               &lt;minLength value="0"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="DISCNT_NAME">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="100"/>
         *               &lt;minLength value="0"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="DISCNT_DESC">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="200"/>
         *               &lt;minLength value="0"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="DISCNT_FEE">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="11"/>
         *               &lt;minLength value="0"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="START_ENABLE">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="1"/>
         *               &lt;minLength value="1"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="ACCESS_TYPE" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="50"/>
         *               &lt;minLength value="0"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="BRAND_SPEED">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="10"/>
         *               &lt;minLength value="0"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="BRAND_NUMBER">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="4"/>
         *               &lt;minLength value="0"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="EXP_MODE" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="1"/>
         *               &lt;minLength value="0"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="DISCNT_CODE_MONTH" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="8"/>
         *               &lt;minLength value="0"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="DISCNT_NAME_MONTH" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="50"/>
         *               &lt;minLength value="0"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="DISCNT_FEE_MONTH" minOccurs="0">
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
            "discntcode",
            "discntname",
            "discntdesc",
            "discntfee",
            "startenable",
            "accesstype",
            "brandspeed",
            "brandnumber",
            "expmode",
            "discntcodemonth",
            "discntnamemonth",
            "discntfeemonth"
        })
        public static class DISCNTINFO {

            @XmlElement(name = "DISCNT_CODE", required = true)
            protected String discntcode;
            @XmlElement(name = "DISCNT_NAME", required = true)
            protected String discntname;
            @XmlElement(name = "DISCNT_DESC", required = true)
            protected String discntdesc;
            @XmlElement(name = "DISCNT_FEE", required = true)
            protected String discntfee;
            @XmlElement(name = "START_ENABLE", required = true)
            protected String startenable;
            @XmlElement(name = "ACCESS_TYPE")
            protected String accesstype;
            @XmlElement(name = "BRAND_SPEED", required = true)
            protected String brandspeed;
            @XmlElement(name = "BRAND_NUMBER", required = true)
            protected String brandnumber;
            @XmlElement(name = "EXP_MODE")
            protected String expmode;
            @XmlElement(name = "DISCNT_CODE_MONTH")
            protected String discntcodemonth;
            @XmlElement(name = "DISCNT_NAME_MONTH")
            protected String discntnamemonth;
            @XmlElement(name = "DISCNT_FEE_MONTH")
            protected String discntfeemonth;

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

            /**
             * Gets the value of the discntname property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDISCNTNAME() {
                return discntname;
            }

            /**
             * Sets the value of the discntname property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDISCNTNAME(String value) {
                this.discntname = value;
            }

            /**
             * Gets the value of the discntdesc property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDISCNTDESC() {
                return discntdesc;
            }

            /**
             * Sets the value of the discntdesc property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDISCNTDESC(String value) {
                this.discntdesc = value;
            }

            /**
             * Gets the value of the discntfee property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDISCNTFEE() {
                return discntfee;
            }

            /**
             * Sets the value of the discntfee property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDISCNTFEE(String value) {
                this.discntfee = value;
            }

            /**
             * Gets the value of the startenable property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSTARTENABLE() {
                return startenable;
            }

            /**
             * Sets the value of the startenable property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSTARTENABLE(String value) {
                this.startenable = value;
            }

            /**
             * Gets the value of the accesstype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getACCESSTYPE() {
                return accesstype;
            }

            /**
             * Sets the value of the accesstype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setACCESSTYPE(String value) {
                this.accesstype = value;
            }

            /**
             * Gets the value of the brandspeed property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBRANDSPEED() {
                return brandspeed;
            }

            /**
             * Sets the value of the brandspeed property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBRANDSPEED(String value) {
                this.brandspeed = value;
            }

            /**
             * Gets the value of the brandnumber property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBRANDNUMBER() {
                return brandnumber;
            }

            /**
             * Sets the value of the brandnumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBRANDNUMBER(String value) {
                this.brandnumber = value;
            }

            /**
             * Gets the value of the expmode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEXPMODE() {
                return expmode;
            }

            /**
             * Sets the value of the expmode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEXPMODE(String value) {
                this.expmode = value;
            }

            /**
             * Gets the value of the discntcodemonth property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDISCNTCODEMONTH() {
                return discntcodemonth;
            }

            /**
             * Sets the value of the discntcodemonth property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDISCNTCODEMONTH(String value) {
                this.discntcodemonth = value;
            }

            /**
             * Gets the value of the discntnamemonth property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDISCNTNAMEMONTH() {
                return discntnamemonth;
            }

            /**
             * Sets the value of the discntnamemonth property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDISCNTNAMEMONTH(String value) {
                this.discntnamemonth = value;
            }

            /**
             * Gets the value of the discntfeemonth property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDISCNTFEEMONTH() {
                return discntfeemonth;
            }

            /**
             * Sets the value of the discntfeemonth property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDISCNTFEEMONTH(String value) {
                this.discntfeemonth = value;
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

}
