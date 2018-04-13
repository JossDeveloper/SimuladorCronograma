
package pe.bf.ws.simulador;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for cuota complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cuota">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fechaAbono" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="interesCuota" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="montoAbono" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="montoAhorroCuota" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="numeroCuota" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tasa" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cuota", propOrder = {
    "fechaAbono",
    "interesCuota",
    "montoAbono",
    "montoAhorroCuota",
    "numeroCuota",
    "tasa"
})
public class Cuota {

    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaAbono;
    protected double interesCuota;
    protected double montoAbono;
    protected double montoAhorroCuota;
    protected int numeroCuota;
    protected double tasa;

    /**
     * Gets the value of the fechaAbono property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaAbono() {
        return fechaAbono;
    }

    /**
     * Sets the value of the fechaAbono property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaAbono(XMLGregorianCalendar value) {
        this.fechaAbono = value;
    }

    /**
     * Gets the value of the interesCuota property.
     * 
     */
    public double getInteresCuota() {
        return interesCuota;
    }

    /**
     * Sets the value of the interesCuota property.
     * 
     */
    public void setInteresCuota(double value) {
        this.interesCuota = value;
    }

    /**
     * Gets the value of the montoAbono property.
     * 
     */
    public double getMontoAbono() {
        return montoAbono;
    }

    /**
     * Sets the value of the montoAbono property.
     * 
     */
    public void setMontoAbono(double value) {
        this.montoAbono = value;
    }

    /**
     * Gets the value of the montoAhorroCuota property.
     * 
     */
    public double getMontoAhorroCuota() {
        return montoAhorroCuota;
    }

    /**
     * Sets the value of the montoAhorroCuota property.
     * 
     */
    public void setMontoAhorroCuota(double value) {
        this.montoAhorroCuota = value;
    }

    /**
     * Gets the value of the numeroCuota property.
     * 
     */
    public int getNumeroCuota() {
        return numeroCuota;
    }

    /**
     * Sets the value of the numeroCuota property.
     * 
     */
    public void setNumeroCuota(int value) {
        this.numeroCuota = value;
    }

    /**
     * Gets the value of the tasa property.
     * 
     */
    public double getTasa() {
        return tasa;
    }

    /**
     * Sets the value of the tasa property.
     * 
     */
    public void setTasa(double value) {
        this.tasa = value;
    }

}
