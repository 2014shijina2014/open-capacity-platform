
package cn.chinaunicom.ws.srenewser.unibssbody;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import cn.chinaunicom.ws.srenewser.unibssbody.srenewtradereq.SRENEWTRADEREQ;
import cn.chinaunicom.ws.unibssattached.UNIBSSATTACHED;
import cn.chinaunicom.ws.unibsshead.UNIBSSHEAD;


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
 *         &lt;element ref="{http://ws.chinaunicom.cn/unibssHead}UNI_BSS_HEAD"/>
 *         &lt;element name="UNI_BSS_BODY">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://ws.chinaunicom.cn/SrenewSer/unibssBody/srenewTradeReq}SRENEW_TRADE_REQ"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://ws.chinaunicom.cn/unibssAttached}UNI_BSS_ATTACHED"/>
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
    "unibsshead",
    "unibssbody",
    "unibssattached"
})
@XmlRootElement(name = "SRENEW_TRADE_INPUT")
public class SRENEWTRADEINPUT {

    @XmlElement(name = "UNI_BSS_HEAD", namespace = "http://ws.chinaunicom.cn/unibssHead", required = true)
    protected UNIBSSHEAD unibsshead;
    @XmlElement(name = "UNI_BSS_BODY", required = true)
    protected SRENEWTRADEINPUT.UNIBSSBODY unibssbody;
    @XmlElement(name = "UNI_BSS_ATTACHED", namespace = "http://ws.chinaunicom.cn/unibssAttached", required = true)
    protected UNIBSSATTACHED unibssattached;

    /**
     * Gets the value of the unibsshead property.
     * 
     * @return
     *     possible object is
     *     {@link UNIBSSHEAD }
     *     
     */
    public UNIBSSHEAD getUNIBSSHEAD() {
        return unibsshead;
    }

    /**
     * Sets the value of the unibsshead property.
     * 
     * @param value
     *     allowed object is
     *     {@link UNIBSSHEAD }
     *     
     */
    public void setUNIBSSHEAD(UNIBSSHEAD value) {
        this.unibsshead = value;
    }

    /**
     * Gets the value of the unibssbody property.
     * 
     * @return
     *     possible object is
     *     {@link SRENEWTRADEINPUT.UNIBSSBODY }
     *     
     */
    public SRENEWTRADEINPUT.UNIBSSBODY getUNIBSSBODY() {
        return unibssbody;
    }

    /**
     * Sets the value of the unibssbody property.
     * 
     * @param value
     *     allowed object is
     *     {@link SRENEWTRADEINPUT.UNIBSSBODY }
     *     
     */
    public void setUNIBSSBODY(SRENEWTRADEINPUT.UNIBSSBODY value) {
        this.unibssbody = value;
    }

    /**
     * Gets the value of the unibssattached property.
     * 
     * @return
     *     possible object is
     *     {@link UNIBSSATTACHED }
     *     
     */
    public UNIBSSATTACHED getUNIBSSATTACHED() {
        return unibssattached;
    }

    /**
     * Sets the value of the unibssattached property.
     * 
     * @param value
     *     allowed object is
     *     {@link UNIBSSATTACHED }
     *     
     */
    public void setUNIBSSATTACHED(UNIBSSATTACHED value) {
        this.unibssattached = value;
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
     *         &lt;element ref="{http://ws.chinaunicom.cn/SrenewSer/unibssBody/srenewTradeReq}SRENEW_TRADE_REQ"/>
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
        "srenewtradereq"
    })
    public static class UNIBSSBODY {

        @XmlElement(name = "SRENEW_TRADE_REQ", namespace = "http://ws.chinaunicom.cn/SrenewSer/unibssBody/srenewTradeReq", required = true)
        protected SRENEWTRADEREQ srenewtradereq;

        /**
         * Gets the value of the srenewtradereq property.
         * 
         * @return
         *     possible object is
         *     {@link SRENEWTRADEREQ }
         *     
         */
        public SRENEWTRADEREQ getSRENEWTRADEREQ() {
            return srenewtradereq;
        }

        /**
         * Sets the value of the srenewtradereq property.
         * 
         * @param value
         *     allowed object is
         *     {@link SRENEWTRADEREQ }
         *     
         */
        public void setSRENEWTRADEREQ(SRENEWTRADEREQ value) {
            this.srenewtradereq = value;
        }

    }

}
