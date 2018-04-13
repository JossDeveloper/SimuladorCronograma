package pe.bf.simulador.ws;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;
import pe.bf.simulador.bean.RespuestaSimulador;
import pe.bf.simulador.bean.SimulacionDatos;
import pe.bf.simulador.ejb.SimuladorEJB;

@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, parameterStyle = SOAPBinding.ParameterStyle.BARE)
@WebService(name = "SimuladorPt", serviceName = "SimuladorService", targetNamespace = "http://pe.company.com/Simulador")
public class SimuladorService {
	@EJB
	private SimuladorEJB simulacionEJB;

	@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
	@Action(input = "http://pe.company.com/Simulador/ahorroNuevoProductoPasivoRequest", output = "http://pe.company.com/Simulador/ahorroNuevoProductoPasivoResponse")
	@WebMethod(operationName = "ahorroNuevoProductoPasivo", action = "http://pe.company.com/Simulador/ahorroNuevoProductoPasivoRequest")
	@WebResult(name = "ahorroNuevoProductoPasivoRespParam", targetNamespace = "http://pe.company.com/Simulador/Resp", partName = "ahorroNuevoProductoPasivoRespParam")

	public RespuestaSimulador ahorroNuevoProductoPasivo(@WebParam(name = "ahorroNuevoProductoPasivoReqParam", partName = "ahorroNuevoProductoPasivoReqParam", targetNamespace = "http://pe.company.com/Simulador/Req") SimulacionDatos simulacionDatos) {
		return simulacionEJB.simularNuevoProductoPasivo(simulacionDatos);

	}
}
