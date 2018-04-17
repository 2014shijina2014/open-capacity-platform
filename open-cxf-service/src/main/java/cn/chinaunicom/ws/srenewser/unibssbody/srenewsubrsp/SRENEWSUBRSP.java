
package cn.chinaunicom.ws.srenewser.unibssbody.srenewsubrsp;

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
    "respcode",
    "respdesc",
    "para"
})
@XmlRootElement(name = "SRENEW_SUB_RSP")
public class SRENEWSUBRSP {

    @XmlElement(name = "RESP_CODE", required = true)
    protected String respcode;
    @XmlElement(name = "RESP_DESC", required = true)
    protected String respdesc;
    @XmlElement(name = "PARA")
    protected List<SRENEWSUBRSP.PARA> para;

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
     * {@link SRENEWSUBRSP.PARA }
     * 
     * 
     */
    public List<SRENEWSUBRSP.PARA> getPARA() {
        if (para == null) {
            para = new ArrayList<SRENEWSUBRSP.PARA>();
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
