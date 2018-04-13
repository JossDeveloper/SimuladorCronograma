package pe.bf.simulador.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespuestaSimulador", propOrder = { "codRespuesta", "msgRespuesta", "correlativoNocliente", "resumenSimulacion", "detalleSimulacion"

})

public class RespuestaSimulador {
	private String codRespuesta;
	private String msgRespuesta;
	private String correlativoNocliente;
	private ResumenSimulacion resumenSimulacion;
	private DetalleSimulacion detalleSimulacion;

	public RespuestaSimulador() {
		//Default empty constructor

	}

	public String getCodRespuesta() {
		return codRespuesta;
	}

	public void setCodRespuesta(String codRespuesta) {
		this.codRespuesta = codRespuesta;
	}

	public String getMsgRespuesta() {
		return msgRespuesta;
	}

	public void setMsgRespuesta(String msgRespuesta) {
		this.msgRespuesta = msgRespuesta;
	}

	public ResumenSimulacion getResumenSimulacion() {
		return resumenSimulacion;
	}

	public void setResumenSimulacion(ResumenSimulacion resumenSimulacion) {
		this.resumenSimulacion = resumenSimulacion;
	}

	public DetalleSimulacion getDetalleSimulacion() {
		return detalleSimulacion;
	}

	public void setDetalleSimulacion(DetalleSimulacion detalleSimulacion) {
		this.detalleSimulacion = detalleSimulacion;
	}

	public String getCorrelativoNocliente() {
		return correlativoNocliente;
	}

	public void setCorrelativoNocliente(String correlativoNocliente) {
		this.correlativoNocliente = correlativoNocliente;
	}

	@Override
	public String toString() {
		return String.format("RespuestaSimulador [codRespuesta=%s, msgRespuesta=%s, correlativoNocliente=%s, resumenSimulacion=%s, detalleSimulacion=%s]", codRespuesta, msgRespuesta, correlativoNocliente, resumenSimulacion, detalleSimulacion);
	}

}
