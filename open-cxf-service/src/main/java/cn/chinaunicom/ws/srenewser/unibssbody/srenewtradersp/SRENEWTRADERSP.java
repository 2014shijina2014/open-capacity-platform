
package cn.chinaunicom.ws.srenewser.unibssbody.srenewtradersp;

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
 *         &lt;element name="RESP_INFO" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TRADE_ID">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="30"/>
 *                         &lt;minLength value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="SUBSCRIBE_ID">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="30"/>
 *                         &lt;minLength value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
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
 *                         &lt;minLength value="0"/>
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
 *                   &lt;element name="PAY_TAG">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="1"/>
 *                         &lt;minLength value="0"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="OLDFEE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="11"/>
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
    "respinfo"
})
@XmlRootElement(name = "SRENEW_TRADE_RSP")
public class SRENEWTRADERSP {

    @XmlElement(name = "RESP_CODE", required = true)
    protected String respcode;
    @XmlElement(name = "RESP_DESC", required = true)
    protected String respdesc;
    @XmlElement(name = "RESP_INFO")
    protected List<SRENEWTRADERSP.RESPINFO> respinfo;

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
     * Gets the value of the respinfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the respinfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRESPINFO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SRENEWTRADERSP.RESPINFO }
     * 
     * 
     */
    public List<SRENEWTRADERSP.RESPINFO> getRESPINFO() {
        if (respinfo == null) {
            respinfo = new ArrayList<SRENEWTRADERSP.RESPINFO>();
        }
        return this.respinfo;
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
     *               &lt;minLength value="0"/>
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
     *         &lt;element name="PAY_TAG">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="1"/>
     *               &lt;minLength value="0"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="OLDFEE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="11"/>
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
        "tradeid",
        "subscribeid",
        "operatetype",
        "feemode",
        "feetypecode",
        "feetypename",
        "paytag",
        "oldfee",
        "fee",
        "para"
    })
    public static class RESPINFO {

        @XmlElement(name = "TRADE_ID", required = true)
        protected String tradeid;
        @XmlElement(name = "SUBSCRIBE_ID", required = true)
        protected String subscribeid;
        @XmlElement(name = "OPERATE_TYPE", required = true)
        protected String operatetype;
        @XmlElement(name = "FEE_MODE", required = true)
        protected String feemode;
        @XmlElement(name = "FEE_TYPE_CODE", required = true)
        protected String feetypecode;
        @XmlElement(name = "FEE_TYPE_NAME", required = true)
        protected String feetypename;
        @XmlElement(name = "PAY_TAG", required = true)
        protected String paytag;
        @XmlElement(name = "OLDFEE", required = true)
        protected String oldfee;
        @XmlElement(name = "FEE", required = true)
        protected String fee;
        @XmlElement(name = "PARA")
        protected List<SRENEWTRADERSP.RESPINFO.PARA> para;

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
         * {@link SRENEWTRADERSP.RESPINFO.PARA }
         * 
         * 
         */
        public List<SRENEWTRADERSP.RESPINFO.PARA> getPARA() {
            if (para == null) {
                para = new ArrayList<SRENEWTRADERSP.RESPINFO.PARA>();
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

}
