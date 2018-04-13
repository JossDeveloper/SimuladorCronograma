package pe.bf.simulador.bean;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;

public class SimulacionDatos {
	private int codProducto;
	private String tipoDocumento;
	private String numDocumento;
	private String codMeta;
	private String dscMeta;
	private double montoMeta;
	@XmlElement
	@XmlSchemaType(name = "date")
	private Date fechaInicioMeta;
	private Double montoAhorroMes;
	private Integer plazoAhorroMes;
	private String usuarioBF;
	private String centroFinanciero;
	private String esCliente;
	private String correlativoNoCliente;
	private String tipoSimulacion;


	public SimulacionDatos() {
		//Default empty constructor
	}

	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getCodMeta() {
		return codMeta;
	}

	public void setCodMeta(String codMeta) {
		this.codMeta = codMeta;
	}

	public String getDscMeta() {
		return dscMeta;
	}

	public void setDscMeta(String dscMeta) {
		this.dscMeta = dscMeta;
	}

	public double getMontoMeta() {
		return montoMeta;
	}

	public void setMontoMeta(double montoMeta) {
		this.montoMeta = montoMeta;
	}

	public Date getFechaInicioMeta() {
		return fechaInicioMeta;
	}

	public void setFechaInicioMeta(Date fechaInicioMeta) {
		this.fechaInicioMeta = fechaInicioMeta;
	}

	public Double getMontoAhorroMes() {
		return montoAhorroMes;
	}

	public void setMontoAhorroMes(Double montoAhorroMes) {
		this.montoAhorroMes = montoAhorroMes;
	}

	public Integer getPlazoAhorroMes() {
		return plazoAhorroMes;
	}

	public void setPlazoAhorroMes(Integer plazoAhorroMes) {
		this.plazoAhorroMes = plazoAhorroMes;
	}

	public String getUsuarioBF() {
		return usuarioBF;
	}

	public void setUsuarioBF(String usuarioBF) {
		this.usuarioBF = usuarioBF;
	}

	public String getCentroFinanciero() {
		return centroFinanciero;
	}

	public void setCentroFinanciero(String centroFinanciero) {
		this.centroFinanciero = centroFinanciero;
	}

	public String getEsCliente() {
		return esCliente;
	}

	public void setEsCliente(String esCliente) {
		this.esCliente = esCliente;
	}

	@XmlTransient // hide elemente in generated xsd
	public String getTipoSimulacion() {
		return tipoSimulacion;
	}

	/**
	 * Debido a que getter anterior es transiente no devuelve los datos en null,
	 * por ello se crea un nuevo método, sin el prefijo get, para que e jax-ws
	 * no lo mapee hacia en xsd
	 *
	 * @return
	 */
	public String obtenerTipoSimulacion() {
		return tipoSimulacion;
	}

	public void setTipoSimulacion(String tipoSimulacion) {
		this.tipoSimulacion = tipoSimulacion;
	}

	public String getCorrelativoNoCliente() {
		return correlativoNoCliente;
	}

	public void setCorrelativoNoCliente(String correlativoNoCliente) {
		this.correlativoNoCliente = correlativoNoCliente;
	}

	@Override
	public String toString() {
		return String.format("SimulacionDatos [codProducto=%s, tipoDocumento=%s, numDocumento=%s, codMeta=%s, dscMeta=%s, montoMeta=%s, fechaInicioMeta=%s, montoAhorroMes=%s, plazoAhorroMes=%s, usuarioBF=%s, centroFinanciero=%s, esCliente=%s, correlativoNoCliente=%s]", codProducto, tipoDocumento,
				numDocumento, codMeta, dscMeta, montoMeta, fechaInicioMeta, montoAhorroMes, plazoAhorroMes, usuarioBF, centroFinanciero, esCliente, correlativoNoCliente);
	}

}
