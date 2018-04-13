
package pe.bf.ws.simulador;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pe.bf.ws.simulador package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AhorroNuevoProductoPasivoReqParam_QNAME = new QName("http://pe.company.com/Simulador/Req", "ahorroNuevoProductoPasivoReqParam");
    private final static QName _AhorroNuevoProductoPasivoRespParam_QNAME = new QName("http://pe.company.com/Simulador/Resp", "ahorroNuevoProductoPasivoRespParam");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pe.bf.ws.simulador
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Cuota }
     * 
     */
    public Cuota createCuota() {
        return new Cuota();
    }

    /**
     * Create an instance of {@link DetalleSimulacion }
     * 
     */
    public DetalleSimulacion createDetalleSimulacion() {
        return new DetalleSimulacion();
    }

    /**
     * Create an instance of {@link ResumenSimulacion }
     * 
     */
    public ResumenSimulacion createResumenSimulacion() {
        return new ResumenSimulacion();
    }

    /**
     * Create an instance of {@link RespuestaSimulador }
     * 
     */
    public RespuestaSimulador createRespuestaSimulador() {
        return new RespuestaSimulador();
    }

    /**
     * Create an instance of {@link SimulacionDatos }
     * 
     */
    public SimulacionDatos createSimulacionDatos() {
        return new SimulacionDatos();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimulacionDatos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pe.company.com/Simulador/Req", name = "ahorroNuevoProductoPasivoReqParam")
    public JAXBElement<SimulacionDatos> createAhorroNuevoProductoPasivoReqParam(SimulacionDatos value) {
        return new JAXBElement<SimulacionDatos>(_AhorroNuevoProductoPasivoReqParam_QNAME, SimulacionDatos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RespuestaSimulador }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pe.company.com/Simulador/Resp", name = "ahorroNuevoProductoPasivoRespParam")
    public JAXBElement<RespuestaSimulador> createAhorroNuevoProductoPasivoRespParam(RespuestaSimulador value) {
        return new JAXBElement<RespuestaSimulador>(_AhorroNuevoProductoPasivoRespParam_QNAME, RespuestaSimulador.class, null, value);
    }

}
