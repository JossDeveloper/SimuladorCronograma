
package pe.bf.ws.simulador;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for resumenSimulacion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="resumenSimulacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codProducto" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="interesAhorro" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="montoAhorroMes" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="montoMeta" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="plazoAhorroMes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalAhorro" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resumenSimulacion", propOrder = {
    "codProducto",
    "interesAhorro",
    "montoAhorroMes",
    "montoMeta",
    "plazoAhorroMes",
    "totalAhorro"
})
public class ResumenSimulacion {

    protected int codProducto;
    protected double interesAhorro;
    protected double montoAhorroMes;
    protected double montoMeta;
    protected int plazoAhorroMes;
    protected double totalAhorro;

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
     * Gets the value of the interesAhorro property.
     * 
     */
    public double getInteresAhorro() {
        return interesAhorro;
    }

    /**
     * Sets the value of the interesAhorro property.
     * 
     */
    public void setInteresAhorro(double value) {
        this.interesAhorro = value;
    }

    /**
     * Gets the value of the montoAhorroMes property.
     * 
     */
    public double getMontoAhorroMes() {
        return montoAhorroMes;
    }

    /**
     * Sets the value of the montoAhorroMes property.
     * 
     */
    public void setMontoAhorroMes(double value) {
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
     * Gets the value of the plazoAhorroMes property.
     * 
     */
    public int getPlazoAhorroMes() {
        return plazoAhorroMes;
    }

    /**
     * Sets the value of the plazoAhorroMes property.
     * 
     */
    public void setPlazoAhorroMes(int value) {
        this.plazoAhorroMes = value;
    }

    /**
     * Gets the value of the totalAhorro property.
     * 
     */
    public double getTotalAhorro() {
        return totalAhorro;
    }

    /**
     * Sets the value of the totalAhorro property.
     * 
     */
    public void setTotalAhorro(double value) {
        this.totalAhorro = value;
    }

}
