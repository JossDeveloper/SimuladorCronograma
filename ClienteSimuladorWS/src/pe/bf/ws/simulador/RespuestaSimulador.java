
package pe.bf.ws.simulador;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RespuestaSimulador complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RespuestaSimulador">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codRespuesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="msgRespuesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="correlativoNocliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resumenSimulacion" type="{http://pe.company.com/Simulador}resumenSimulacion" minOccurs="0"/>
 *         &lt;element name="detalleSimulacion" type="{http://pe.company.com/Simulador}detalleSimulacion" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespuestaSimulador", propOrder = {
    "codRespuesta",
    "msgRespuesta",
    "correlativoNocliente",
    "resumenSimulacion",
    "detalleSimulacion"
})
public class RespuestaSimulador {

    protected String codRespuesta;
    protected String msgRespuesta;
    protected String correlativoNocliente;
    protected ResumenSimulacion resumenSimulacion;
    protected DetalleSimulacion detalleSimulacion;

    /**
     * Gets the value of the codRespuesta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodRespuesta() {
        return codRespuesta;
    }

    /**
     * Sets the value of the codRespuesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodRespuesta(String value) {
        this.codRespuesta = value;
    }

    /**
     * Gets the value of the msgRespuesta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgRespuesta() {
        return msgRespuesta;
    }

    /**
     * Sets the value of the msgRespuesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgRespuesta(String value) {
        this.msgRespuesta = value;
    }

    /**
     * Gets the value of the correlativoNocliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelativoNocliente() {
        return correlativoNocliente;
    }

    /**
     * Sets the value of the correlativoNocliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelativoNocliente(String value) {
        this.correlativoNocliente = value;
    }

    /**
     * Gets the value of the resumenSimulacion property.
     * 
     * @return
     *     possible object is
     *     {@link ResumenSimulacion }
     *     
     */
    public ResumenSimulacion getResumenSimulacion() {
        return resumenSimulacion;
    }

    /**
     * Sets the value of the resumenSimulacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResumenSimulacion }
     *     
     */
    public void setResumenSimulacion(ResumenSimulacion value) {
        this.resumenSimulacion = value;
    }

    /**
     * Gets the value of the detalleSimulacion property.
     * 
     * @return
     *     possible object is
     *     {@link DetalleSimulacion }
     *     
     */
    public DetalleSimulacion getDetalleSimulacion() {
        return detalleSimulacion;
    }

    /**
     * Sets the value of the detalleSimulacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link DetalleSimulacion }
     *     
     */
    public void setDetalleSimulacion(DetalleSimulacion value) {
        this.detalleSimulacion = value;
    }

}
