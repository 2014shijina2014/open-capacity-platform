
package cn.chinaunicom.ws.unibsshead;

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
 *         &lt;element name="ORIG_DOMAIN">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SERVICE_NAME">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="60"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OPERATE_NAME">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="60"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ACTION_CODE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ACTION_RELATION">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ROUTING">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ROUTE_TYPE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ROUTE_VALUE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="0"/>
 *                         &lt;maxLength value="60"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PROC_ID">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TRANS_IDO">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TRANS_IDH" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="0"/>
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PROCESS_TIME">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="14"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RESPONSE" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="RSP_TYPE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="RSP_CODE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="RSP_DESC">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="0"/>
 *                         &lt;maxLength value="512"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="COM_BUS_INFO" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="OPER_ID">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="0"/>
 *                         &lt;maxLength value="20"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="PROVINCE_CODE" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="EPARCHY_CODE" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="0"/>
 *                         &lt;maxLength value="6"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CITY_CODE" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="0"/>
 *                         &lt;maxLength value="60"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CHANNEL_ID">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="0"/>
 *                         &lt;maxLength value="20"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CHANNEL_TYPE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="7"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ACCESS_TYPE">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="ORDER_TYPE" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="2"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SP_RESERVE">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TRANS_IDC" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="0"/>
 *                         &lt;maxLength value="60"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CUTOFFDAY" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="0"/>
 *                         &lt;maxLength value="8"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="OSNDUNS">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;length value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="HSNDUNS" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="0"/>
 *                         &lt;maxLength value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="CONV_ID" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;minLength value="0"/>
 *                         &lt;maxLength value="60"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TEST_FLAG">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MSG_SENDER">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MSG_RECEIVER">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="4"/>
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
    "origdomain",
    "servicename",
    "operatename",
    "actioncode",
    "actionrelation",
    "routing",
    "procid",
    "transido",
    "transidh",
    "processtime",
    "response",
    "combusinfo",
    "spreserve",
    "testflag",
    "msgsender",
    "msgreceiver"
})
@XmlRootElement(name = "UNI_BSS_HEAD")
public class UNIBSSHEAD {

    @XmlElement(name = "ORIG_DOMAIN", required = true)
    protected String origdomain;
    @XmlElement(name = "SERVICE_NAME", required = true)
    protected String servicename;
    @XmlElement(name = "OPERATE_NAME", required = true)
    protected String operatename;
    @XmlElement(name = "ACTION_CODE", required = true)
    protected String actioncode;
    @XmlElement(name = "ACTION_RELATION", required = true)
    protected String actionrelation;
    @XmlElement(name = "ROUTING", required = true)
    protected UNIBSSHEAD.ROUTING routing;
    @XmlElement(name = "PROC_ID", required = true)
    protected String procid;
    @XmlElement(name = "TRANS_IDO", required = true)
    protected String transido;
    @XmlElement(name = "TRANS_IDH")
    protected String transidh;
    @XmlElement(name = "PROCESS_TIME", required = true)
    protected String processtime;
    @XmlElement(name = "RESPONSE")
    protected UNIBSSHEAD.RESPONSE response;
    @XmlElement(name = "COM_BUS_INFO")
    protected UNIBSSHEAD.COMBUSINFO combusinfo;
    @XmlElement(name = "SP_RESERVE", required = true)
    protected UNIBSSHEAD.SPRESERVE spreserve;
    @XmlElement(name = "TEST_FLAG", required = true)
    protected String testflag;
    @XmlElement(name = "MSG_SENDER", required = true)
    protected String msgsender;
    @XmlElement(name = "MSG_RECEIVER", required = true)
    protected String msgreceiver;

    /**
     * Gets the value of the origdomain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORIGDOMAIN() {
        return origdomain;
    }

    /**
     * Sets the value of the origdomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORIGDOMAIN(String value) {
        this.origdomain = value;
    }

    /**
     * Gets the value of the servicename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVICENAME() {
        return servicename;
    }

    /**
     * Sets the value of the servicename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVICENAME(String value) {
        this.servicename = value;
    }

    /**
     * Gets the value of the operatename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOPERATENAME() {
        return operatename;
    }

    /**
     * Sets the value of the operatename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOPERATENAME(String value) {
        this.operatename = value;
    }

    /**
     * Gets the value of the actioncode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACTIONCODE() {
        return actioncode;
    }

    /**
     * Sets the value of the actioncode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACTIONCODE(String value) {
        this.actioncode = value;
    }

    /**
     * Gets the value of the actionrelation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACTIONRELATION() {
        return actionrelation;
    }

    /**
     * Sets the value of the actionrelation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACTIONRELATION(String value) {
        this.actionrelation = value;
    }

    /**
     * Gets the value of the routing property.
     * 
     * @return
     *     possible object is
     *     {@link UNIBSSHEAD.ROUTING }
     *     
     */
    public UNIBSSHEAD.ROUTING getROUTING() {
        return routing;
    }

    /**
     * Sets the value of the routing property.
     * 
     * @param value
     *     allowed object is
     *     {@link UNIBSSHEAD.ROUTING }
     *     
     */
    public void setROUTING(UNIBSSHEAD.ROUTING value) {
        this.routing = value;
    }

    /**
     * Gets the value of the procid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROCID() {
        return procid;
    }

    /**
     * Sets the value of the procid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROCID(String value) {
        this.procid = value;
    }

    /**
     * Gets the value of the transido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANSIDO() {
        return transido;
    }

    /**
     * Sets the value of the transido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANSIDO(String value) {
        this.transido = value;
    }

    /**
     * Gets the value of the transidh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANSIDH() {
        return transidh;
    }

    /**
     * Sets the value of the transidh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANSIDH(String value) {
        this.transidh = value;
    }

    /**
     * Gets the value of the processtime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROCESSTIME() {
        return processtime;
    }

    /**
     * Sets the value of the processtime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROCESSTIME(String value) {
        this.processtime = value;
    }

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link UNIBSSHEAD.RESPONSE }
     *     
     */
    public UNIBSSHEAD.RESPONSE getRESPONSE() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link UNIBSSHEAD.RESPONSE }
     *     
     */
    public void setRESPONSE(UNIBSSHEAD.RESPONSE value) {
        this.response = value;
    }

    /**
     * Gets the value of the combusinfo property.
     * 
     * @return
     *     possible object is
     *     {@link UNIBSSHEAD.COMBUSINFO }
     *     
     */
    public UNIBSSHEAD.COMBUSINFO getCOMBUSINFO() {
        return combusinfo;
    }

    /**
     * Sets the value of the combusinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link UNIBSSHEAD.COMBUSINFO }
     *     
     */
    public void setCOMBUSINFO(UNIBSSHEAD.COMBUSINFO value) {
        this.combusinfo = value;
    }

    /**
     * Gets the value of the spreserve property.
     * 
     * @return
     *     possible object is
     *     {@link UNIBSSHEAD.SPRESERVE }
     *     
     */
    public UNIBSSHEAD.SPRESERVE getSPRESERVE() {
        return spreserve;
    }

    /**
     * Sets the value of the spreserve property.
     * 
     * @param value
     *     allowed object is
     *     {@link UNIBSSHEAD.SPRESERVE }
     *     
     */
    public void setSPRESERVE(UNIBSSHEAD.SPRESERVE value) {
        this.spreserve = value;
    }

    /**
     * Gets the value of the testflag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTESTFLAG() {
        return testflag;
    }

    /**
     * Sets the value of the testflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTESTFLAG(String value) {
        this.testflag = value;
    }

    /**
     * Gets the value of the msgsender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGSENDER() {
        return msgsender;
    }

    /**
     * Sets the value of the msgsender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGSENDER(String value) {
        this.msgsender = value;
    }

    /**
     * Gets the value of the msgreceiver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGRECEIVER() {
        return msgreceiver;
    }

    /**
     * Sets the value of the msgreceiver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGRECEIVER(String value) {
        this.msgreceiver = value;
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
     *         &lt;element name="OPER_ID">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="0"/>
     *               &lt;maxLength value="20"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="PROVINCE_CODE" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="EPARCHY_CODE" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="0"/>
     *               &lt;maxLength value="6"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CITY_CODE" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="0"/>
     *               &lt;maxLength value="60"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CHANNEL_ID">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="0"/>
     *               &lt;maxLength value="20"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CHANNEL_TYPE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="7"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ACCESS_TYPE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ORDER_TYPE" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="2"/>
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
        "operid",
        "provincecode",
        "eparchycode",
        "citycode",
        "channelid",
        "channeltype",
        "accesstype",
        "ordertype"
    })
    public static class COMBUSINFO {

        @XmlElement(name = "OPER_ID", required = true)
        protected String operid;
        @XmlElement(name = "PROVINCE_CODE")
        protected String provincecode;
        @XmlElement(name = "EPARCHY_CODE")
        protected String eparchycode;
        @XmlElement(name = "CITY_CODE")
        protected String citycode;
        @XmlElement(name = "CHANNEL_ID", required = true)
        protected String channelid;
        @XmlElement(name = "CHANNEL_TYPE", required = true)
        protected String channeltype;
        @XmlElement(name = "ACCESS_TYPE", required = true)
        protected String accesstype;
        @XmlElement(name = "ORDER_TYPE")
        protected String ordertype;

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
         * Gets the value of the citycode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCITYCODE() {
            return citycode;
        }

        /**
         * Sets the value of the citycode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCITYCODE(String value) {
            this.citycode = value;
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
         * Gets the value of the channeltype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCHANNELTYPE() {
            return channeltype;
        }

        /**
         * Sets the value of the channeltype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCHANNELTYPE(String value) {
            this.channeltype = value;
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
         * Gets the value of the ordertype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getORDERTYPE() {
            return ordertype;
        }

        /**
         * Sets the value of the ordertype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setORDERTYPE(String value) {
            this.ordertype = value;
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
     *         &lt;element name="RSP_TYPE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="1"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="RSP_CODE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="4"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="RSP_DESC">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="0"/>
     *               &lt;maxLength value="512"/>
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
        "rsptype",
        "rspcode",
        "rspdesc"
    })
    public static class RESPONSE {

        @XmlElement(name = "RSP_TYPE", required = true)
        protected String rsptype;
        @XmlElement(name = "RSP_CODE", required = true)
        protected String rspcode;
        @XmlElement(name = "RSP_DESC", required = true)
        protected String rspdesc;

        /**
         * Gets the value of the rsptype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRSPTYPE() {
            return rsptype;
        }

        /**
         * Sets the value of the rsptype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRSPTYPE(String value) {
            this.rsptype = value;
        }

        /**
         * Gets the value of the rspcode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRSPCODE() {
            return rspcode;
        }

        /**
         * Sets the value of the rspcode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRSPCODE(String value) {
            this.rspcode = value;
        }

        /**
         * Gets the value of the rspdesc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRSPDESC() {
            return rspdesc;
        }

        /**
         * Sets the value of the rspdesc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRSPDESC(String value) {
            this.rspdesc = value;
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
     *         &lt;element name="ROUTE_TYPE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ROUTE_VALUE">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="0"/>
     *               &lt;maxLength value="60"/>
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
        "routetype",
        "routevalue"
    })
    public static class ROUTING {

        @XmlElement(name = "ROUTE_TYPE", required = true)
        protected String routetype;
        @XmlElement(name = "ROUTE_VALUE", required = true)
        protected String routevalue;

        /**
         * Gets the value of the routetype property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getROUTETYPE() {
            return routetype;
        }

        /**
         * Sets the value of the routetype property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setROUTETYPE(String value) {
            this.routetype = value;
        }

        /**
         * Gets the value of the routevalue property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getROUTEVALUE() {
            return routevalue;
        }

        /**
         * Sets the value of the routevalue property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setROUTEVALUE(String value) {
            this.routevalue = value;
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
     *         &lt;element name="TRANS_IDC" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="0"/>
     *               &lt;maxLength value="60"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CUTOFFDAY" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="0"/>
     *               &lt;maxLength value="8"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="OSNDUNS">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="4"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="HSNDUNS" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="0"/>
     *               &lt;maxLength value="4"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="CONV_ID" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;minLength value="0"/>
     *               &lt;maxLength value="60"/>
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
        "transidc",
        "cutoffday",
        "osnduns",
        "hsnduns",
        "convid"
    })
    public static class SPRESERVE {

        @XmlElement(name = "TRANS_IDC")
        protected String transidc;
        @XmlElement(name = "CUTOFFDAY")
        protected String cutoffday;
        @XmlElement(name = "OSNDUNS", required = true)
        protected String osnduns;
        @XmlElement(name = "HSNDUNS")
        protected String hsnduns;
        @XmlElement(name = "CONV_ID")
        protected String convid;

        /**
         * Gets the value of the transidc property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTRANSIDC() {
            return transidc;
        }

        /**
         * Sets the value of the transidc property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTRANSIDC(String value) {
            this.transidc = value;
        }

        /**
         * Gets the value of the cutoffday property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCUTOFFDAY() {
            return cutoffday;
        }

        /**
         * Sets the value of the cutoffday property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCUTOFFDAY(String value) {
            this.cutoffday = value;
        }

        /**
         * Gets the value of the osnduns property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOSNDUNS() {
            return osnduns;
        }

        /**
         * Sets the value of the osnduns property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOSNDUNS(String value) {
            this.osnduns = value;
        }

        /**
         * Gets the value of the hsnduns property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHSNDUNS() {
            return hsnduns;
        }

        /**
         * Sets the value of the hsnduns property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHSNDUNS(String value) {
            this.hsnduns = value;
        }

        /**
         * Gets the value of the convid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCONVID() {
            return convid;
        }

        /**
         * Sets the value of the convid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCONVID(String value) {
            this.convid = value;
        }

    }

}
