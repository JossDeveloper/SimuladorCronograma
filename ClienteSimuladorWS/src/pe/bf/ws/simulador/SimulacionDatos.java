
package pe.bf.ws.simulador;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for simulacionDatos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="simulacionDatos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fechaInicioMeta" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="centroFinanciero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codMeta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codProducto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="correlativoNoCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dscMeta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="esCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="montoAhorroMes" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="montoMeta" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="numDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plazoAhorroMes" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="tipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usuarioBF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simulacionDatos", propOrder = {
    "fechaInicioMeta",
    "centroFinanciero",
    "codMeta",
    "codProducto",
    "correlativoNoCliente",
    "dscMeta",
    "esCliente",
    "montoAhorroMes",
    "montoMeta",
    "numDocumento",
    "plazoAhorroMes",
    "tipoDocumento",
    "usuarioBF"
})
public class SimulacionDatos {

    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaInicioMeta;
    protected String centroFinanciero;
    protected String codMeta;
    protected int codProducto;
    protected String correlativoNoCliente;
    protected String dscMeta;
    protected String esCliente;
    protected Double montoAhorroMes;
    protected double montoMeta;
    protected String numDocumento;
    protected Integer plazoAhorroMes;
    protected String tipoDocumento;
    protected String usuarioBF;

    /**
     * Gets the value of the fechaInicioMeta property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaInicioMeta() {
        return fechaInicioMeta;
    }

    /**
     * Sets the value of the fechaInicioMeta property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaInicioMeta(XMLGregorianCalendar value) {
        this.fechaInicioMeta = value;
    }

    /**
     * Gets the value of the centroFinanciero property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCentroFinanciero() {
        return centroFinanciero;
    }

    /**
     * Sets the value of the centroFinanciero property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCentroFinanciero(String value) {
        this.centroFinanciero = value;
    }

    /**
     * Gets the value of the codMeta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodMeta() {
        return codMeta;
    }

    /**
     * Sets the value of the codMeta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodMeta(String value) {
        this.codMeta = value;
    }

    /**
     * Gets the value of the codProducto property.
     * 
     */
    public int getCodProducto() {
        return codProducto;
    }

    /**
     * Sets the value of the codProducto property.
     * 
     */
    public void setCodProducto(int value) {
        this.codProducto = value;
    }

    /**
     * Gets the value of the correlativoNoCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelativoNoCliente() {
        return correlativoNoCliente;
    }

    /**
     * Sets the value of the correlativoNoCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelativoNoCliente(String value) {
        this.correlativoNoCliente = value;
    }

    /**
     * Gets the value of the dscMeta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDscMeta() {
        return dscMeta;
    }

    /**
     * Sets the value of the dscMeta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDscMeta(String value) {
        this.dscMeta = value;
    }

    /**
     * Gets the value of the esCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsCliente() {
        return esCliente;
    }

    /**
     * Sets the value of the esCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsCliente(String value) {
        this.esCliente = value;
    }

    /**
     * Gets the value of the montoAhorroMes property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMontoAhorroMes() {
        return montoAhorroMes;
    }

    /**
     * Sets the value of the montoAhorroMes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMontoAhorroMes(Double value) {
        this.montoAhorroMes = value;
    }

    /**
     * Gets the value of the montoMeta property.
     * 
     */
    public double getMontoMeta() {
        return montoMeta;
    }

    /**
     * Sets the value of the montoMeta property.
     * 
     */
    public void setMontoMeta(double value) {
        this.montoMeta = value;
    }

    /**
     * Gets the value of the numDocumento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumDocumento() {
        return numDocumento;
    }

    /**
     * Sets the value of the numDocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumDocumento(String value) {
        this.numDocumento = value;
    }

    /**
     * Gets the value of the plazoAhorroMes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPlazoAhorroMes() {
        return plazoAhorroMes;
    }

    /**
     * Sets the value of the plazoAhorroMes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPlazoAhorroMes(Integer value) {
        this.plazoAhorroMes = value;
    }

    /**
     * Gets the value of the tipoDocumento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Sets the value of the tipoDocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDocumento(String value) {
        this.tipoDocumento = value;
    }

    /**
     * Gets the value of the usuarioBF property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuarioBF() {
        return usuarioBF;
    }

    /**
     * Sets the value of the usuarioBF property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuarioBF(String value) {
        this.usuarioBF = value;
    }

}
