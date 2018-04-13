package pe.bf.ws.simulador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class SimuladorTest 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("[TEST : SimuladorWS] - Probando... ");
		System.setProperty("SERVER_WS", "http://127.0.0.1:8001");
		
		Date fecha = stringToDate("2017-07-31");
		XMLGregorianCalendar xmlfec = toXMLGregorianCalendar(fecha);
		
		SimulacionDatos req = new SimulacionDatos();
		req.setCodProducto(200);
		req.setCodMeta("1");
		req.setDscMeta("Estudios");
		req.setMontoMeta(3000.00);
		req.setFechaInicioMeta(xmlfec);
		req.setMontoAhorroMes(200.00);
		req.setTipoDocumento("1");
		req.setNumDocumento("46786491");
		req.setEsCliente("S");
		req.setCentroFinanciero("0609");
		req.setUsuarioBF("11111");
		
		SimuladorService service = new SimuladorService();
		SimuladorPt sws = service.getSimuladorPtPort();
		
		
		RespuestaSimulador rpta = sws.ahorroNuevoProductoPasivo(req);
		
		System.out.println("Response codRpta: " + rpta.getCodRespuesta());
		System.out.println("Response msgRpta: " + rpta.getMsgRespuesta());
		System.out.println("Response correlativo: " + rpta.getCorrelativoNocliente());
		System.out.println("datos Resumen: " + rpta.getResumenSimulacion().getCodProducto());
		System.out.println("datos Resumen: " + rpta.getResumenSimulacion().getMontoMeta());
		System.out.println("datos Resumen: " + rpta.getResumenSimulacion().getPlazoAhorroMes());
		System.out.println("datos Resumen: " + rpta.getResumenSimulacion().getMontoAhorroMes());
		System.out.println("datos Resumen: " + rpta.getResumenSimulacion().getInteresAhorro());
		System.out.println("datos Resumen: " + rpta.getResumenSimulacion().getTotalAhorro());
		System.out.println("datos Detalle: " + rpta.getDetalleSimulacion().getCronograma().get(0).getNumeroCuota());
		System.out.println("datos Detalle: " + rpta.getDetalleSimulacion().getCronograma().get(0).getFechaAbono());
		System.out.println("datos Detalle: " + rpta.getDetalleSimulacion().getCronograma().get(0).getMontoAbono());
		System.out.println("datos Detalle: " + rpta.getDetalleSimulacion().getCronograma().get(0).getInteresCuota());
		System.out.println("datos Detalle: " + rpta.getDetalleSimulacion().getCronograma().get(0).getTasa());
		System.out.println("datos Detalle: " + rpta.getDetalleSimulacion().getCronograma().get(0).getMontoAhorroCuota());

	}
	
	
	public static Date stringToDate(String dateIn){
		//logger.info("[FrontOffice : DateUtil] --> dateIn : " + dateIn);
		Date fecha = null;
		try {
			if(null != dateIn){
				//Si es mayor a 6 posibles valores yyyy-MM o yyyy-MM-dd
				if(dateIn.length() > 6){
					dateIn = dateIn.replaceAll("-", "");
				}				
				//Si es menor a 6 posibles valores yyyyMM
				switch(dateIn.length()){
					case 6: fecha = new SimpleDateFormat("yyyyMM", Locale.ENGLISH).parse(dateIn);
					break;
					case 8:	fecha = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(dateIn);
					break;
				}
			}
		} 
		catch (ParseException e) {
			System.out.println("[catch]Error al realizar prueba, mensaje : " + e.getMessage());
		}
		return fecha;
	}
	
	public static XMLGregorianCalendar toXMLGregorianCalendar(Date date){
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTime(date);
		XMLGregorianCalendar xmlCalendar = null;
		try {
			xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
		} 
		catch (DatatypeConfigurationException ex) {
		}
		return xmlCalendar;
	}
}
