package pe.bf.simulador.ejb;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.Stateless;
import org.apache.log4j.Logger;
import pe.bf.simulador.bean.Cuota;
import pe.bf.simulador.bean.DetalleSimulacion;
import pe.bf.simulador.bean.RespuestaSimulador;
import pe.bf.simulador.bean.ResumenSimulacion;
import pe.bf.simulador.bean.SimulacionDatos;
import pe.bf.simulador.dao.SimuladorDAO;

@Stateless
public class SimuladorEJB extends BaseEJB 
{
	private static final Logger logger = Logger.getLogger(SimuladorEJB.class);

	/**
	 * Método que realiza la simulación y generación de cronograma para
	 * determinado producto de ahorro.
	 * @param simulacionDatos
	 * @return
	 */
	public RespuestaSimulador simularNuevoProductoPasivo(SimulacionDatos simulacionDatos) 
	{
		RespuestaSimulador respuestaSimulador = new RespuestaSimulador();
		respuestaSimulador.setCodRespuesta("01");
		respuestaSimulador.setMsgRespuesta("Ocurrió un error al ejecutar la simulación.");
		String validacion = validate(simulacionDatos);
		try 
		{
			if (validacion == null) 
			{
				logger.info("Validacion de datos INPUT exitosa");
				SimuladorDAO simuladorDAO = new SimuladorDAO(datasource);
				double tasaEfectivaAnual = simuladorDAO.getTasaNuevoProductoPasivo(simulacionDatos.getCodProducto());
				BigDecimal tasa = BigDecimal.valueOf(tasaEfectivaAnual).divide(new BigDecimal("100"));
				logger.info("Valor de la TEA = " + tasa.doubleValue());
				//inicializando variables a calcular
				double montoAhorroMes = 0; int plazoAhorroMes = 0, plazoAhorroMax = 0;
				
				// Calculando Monto Ahorro a partir del plazo
				if (simulacionDatos.getMontoAhorroMes() == null || "".equals(simulacionDatos.getMontoAhorroMes().toString())) 
				{
					logger.info("Simulacion tipo Monto Ahorro mensual");
					plazoAhorroMes = simulacionDatos.getPlazoAhorroMes().intValue();
					montoAhorroMes = redondear(simulacionDatos.getMontoMeta() / plazoAhorroMes, 2);
					logger.info("montoAhorroMes=" + montoAhorroMes);
					simulacionDatos.setMontoAhorroMes(montoAhorroMes);
					simulacionDatos.setTipoSimulacion("Monto Ahorro");
				} else
				// Calculando el plazo a partir del monto ahorro mensual
				if (simulacionDatos.getPlazoAhorroMes() == null || "".equals(simulacionDatos.getPlazoAhorroMes().toString())) 
				{
					logger.info("Simulacion tipo Plazo Ahorro meses");
					montoAhorroMes = simulacionDatos.getMontoAhorroMes().doubleValue();
					plazoAhorroMax = simuladorDAO.getMaximoMesesSimulacion("MAX_MESES_SIMULACION_NPP");
					plazoAhorroMes = (int) Math.ceil(simulacionDatos.getMontoMeta() / montoAhorroMes);
					logger.info("plazoAhorroMes=" + plazoAhorroMes + " / plazoAhorroMax=" + plazoAhorroMax);
					//mayor a 10 anhos
					if (plazoAhorroMes > plazoAhorroMax) 
					{
						respuestaSimulador.setCodRespuesta("01");
						respuestaSimulador.setMsgRespuesta("El Monto Ahorro Mensual debe ser mayor debido a que el plazo calculado excede los 10 a\u00f1os.");
						logger.info(respuestaSimulador.toString());
						return respuestaSimulador;
					}
					simulacionDatos.setPlazoAhorroMes(plazoAhorroMes);
					simulacionDatos.setTipoSimulacion("Plazo Ahorro");
				}

				ResumenSimulacion resumenSimulacion = new ResumenSimulacion();
				DetalleSimulacion detalleSimulacion = new DetalleSimulacion();
				
				resumenSimulacion.setCodProducto(simulacionDatos.getCodProducto());
				resumenSimulacion.setMontoMeta(simulacionDatos.getMontoMeta());
				resumenSimulacion.setMontoAhorroMes(simulacionDatos.getMontoAhorroMes());
				resumenSimulacion.setPlazoAhorroMes(simulacionDatos.getPlazoAhorroMes());
				
				detalleSimulacion = this.generarCronogramaAhorroNPP(resumenSimulacion, tasa, simulacionDatos.getFechaInicioMeta());
				
				double totalAhorro = redondear(detalleSimulacion.getCronograma().get(plazoAhorroMes - 1).getMontoAhorroCuota(), 2);
				double totalAbonox = redondear(detalleSimulacion.getCronograma().get(plazoAhorroMes - 1).getMontoAbono() + (montoAhorroMes * (plazoAhorroMes - 1)), 2);
				
				resumenSimulacion.setTotalAhorro(totalAhorro);
				resumenSimulacion.setInteresAhorro(redondear(totalAhorro - totalAbonox, 2));
				
				
				respuestaSimulador.setResumenSimulacion(resumenSimulacion);
				respuestaSimulador.setDetalleSimulacion(detalleSimulacion);
				logger.info("Generando ResumenSimulacion: " + respuestaSimulador.getResumenSimulacion());
				logger.info("Generando DetalleSimulacion: " + respuestaSimulador.getDetalleSimulacion());
				
				respuestaSimulador.setCodRespuesta("00");
				respuestaSimulador.setMsgRespuesta("Simulación Existosa.");
//				simuladorDAO.setDataSource(datasource);
//				RespuestaSimulador respuestaSimuladorRegistro = simuladorDAO.grabarNuevoProductoPasivo(simulacionDatos, resumenSimulacion);
//				respuestaSimulador.setCodRespuesta(respuestaSimuladorRegistro.getCodRespuesta());
//				respuestaSimulador.setMsgRespuesta(respuestaSimuladorRegistro.getMsgRespuesta());
//				respuestaSimulador.setCorrelativoNocliente(respuestaSimuladorRegistro.getCorrelativoNocliente());
				respuestaSimulador.setCorrelativoNocliente("");

			} else {
				respuestaSimulador.setCodRespuesta("01");
				respuestaSimulador.setMsgRespuesta(validacion);
			}
		} catch (Exception e) {
			logger.error(e);
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			String stackTraceError = stringWriter.toString();
			respuestaSimulador.setCodRespuesta("02");
			respuestaSimulador.setMsgRespuesta(stackTraceError);
			respuestaSimulador.setResumenSimulacion(null);
			respuestaSimulador.setDetalleSimulacion(null);
		}
		logger.info(respuestaSimulador.toString());
		return respuestaSimulador;
	}
	
	private DetalleSimulacion generarCronogramaAhorroNPP(ResumenSimulacion resumenSimulacion, BigDecimal tasa, Date fechaInicioMeta)
	{
		DetalleSimulacion detalleSimulacion = new DetalleSimulacion();
		//tratamiento de fechas
		Calendar fechaAbono = Calendar.getInstance();
		Calendar fechaInicioMetaCalendar = Calendar.getInstance();
		fechaInicioMetaCalendar.setTime(fechaInicioMeta);
		fechaAbono.setTime(fechaInicioMeta);
		//tratamiento de dias
		int diasMesActual = 0;
		int diasTransPer1 = 0;
		int diasTransPer2 = 0;
		//tratamiento de montos
		BigDecimal montoAhorroMesAbonadoCl = new BigDecimal(0);
		BigDecimal montoAhorroMesAnteriorx = new BigDecimal(0); 
		BigDecimal montoAhorroMesAcumulado = new BigDecimal(0);
		//generar cronograma a partir del plazo en meses
		try
		{
			for (int i = 1; i <= resumenSimulacion.getPlazoAhorroMes(); i++) 
			{
				
				Cuota cuota = new Cuota();
				//calcular dias transcurridos
				diasMesActual = fechaAbono.getActualMaximum(Calendar.DAY_OF_MONTH);
				diasTransPer1 = i != 1 ? fechaAbono.get(Calendar.DATE) : 0;
				diasTransPer2 = (diasMesActual - fechaAbono.get(Calendar.DATE));
				//calcular tasas aplicables
				BigDecimal tasaPer1 = (BigDecimal.valueOf(Math.pow(1 + tasa.doubleValue(), (double) diasTransPer1 / 360) - 1));
				BigDecimal tasaPer2 = (BigDecimal.valueOf(Math.pow(1 + tasa.doubleValue(), (double) diasTransPer2 / 360) - 1));
				BigDecimal interesPer1 = new BigDecimal(0);
				BigDecimal interesPer2 = new BigDecimal(0);
				BigDecimal interesSuma = new BigDecimal(0);
				BigDecimal metaCliente = new BigDecimal(resumenSimulacion.getMontoMeta());
				BigDecimal montoAhoMes = new BigDecimal(resumenSimulacion.getMontoAhorroMes());
				BigDecimal montoUltMes = new BigDecimal(0);
				//calcular importe abonado
				montoAhorroMesAbonadoCl = montoAhorroMesAbonadoCl.add(montoAhoMes);
				//evaluar si el abono del cliente supera la meta
				int r = montoAhorroMesAbonadoCl.compareTo(metaCliente);
				//evaluar escenario de simulacion
				switch (r) 
				{
					case  1 :
						//calcular monto ahorro mensual
						montoUltMes = metaCliente.subtract((montoAhorroMesAbonadoCl.subtract(montoAhoMes)));
						montoAhorroMesAnteriorx = montoAhorroMesAcumulado.add(new BigDecimal(detalleSimulacion.getCronograma().get(i - 2).getInteresCuota()));
						montoAhorroMesAcumulado = montoAhorroMesAnteriorx.add(montoUltMes);
						interesSuma = new BigDecimal(0); break;
					case  0 :
						//calcular monto ahorro mensual
						montoUltMes = montoAhoMes;
						montoAhorroMesAnteriorx = montoAhorroMesAcumulado.add(new BigDecimal(detalleSimulacion.getCronograma().get(i - 2).getInteresCuota()));
						montoAhorroMesAcumulado = montoAhorroMesAnteriorx.add(montoUltMes);
						interesSuma = new BigDecimal(0); break;
					case -1 :
						//calcular monto ahorro mensual
						if (i == 1)
						{
							montoAhorroMesAnteriorx = new BigDecimal(0);
							montoAhorroMesAcumulado = montoAhoMes;
						} else {
							montoAhorroMesAnteriorx = montoAhorroMesAcumulado.add(new BigDecimal(detalleSimulacion.getCronograma().get(i - 2).getInteresCuota()));
							montoAhorroMesAcumulado = montoAhorroMesAnteriorx.add(montoAhoMes);
						}
						//calcular intereses acumulados
						interesPer1 = tasaPer1.multiply(montoAhorroMesAnteriorx);
						interesPer2 = tasaPer2.multiply(montoAhorroMesAcumulado);
						interesSuma = interesSuma.add(interesPer1).add(interesPer2); break;
					default :  break;
				}
				cuota.setNumeroCuota(i);
				cuota.setTasa(redondear((tasa.doubleValue() * 100), 2));
				cuota.setFechaAbono(fechaAbono.getTime());
				cuota.setInteresCuota(interesSuma.doubleValue());
				cuota.setMontoAhorroCuota((montoAhorroMesAcumulado.add(interesSuma)).doubleValue());
				//evaluar si es ultima cuota
				if (i == resumenSimulacion.getPlazoAhorroMes())
				{
					cuota.setMontoAbono(redondear(montoUltMes.doubleValue(), 2));
				} else {
					cuota.setMontoAbono(redondear(montoAhoMes.doubleValue(), 2));
				}
				//calcular la siguiente fecha de ahorro
				//fechaAbono.add(Calendar.MONTH, 1);
				fechaAbono = calcularFechaAbono(fechaAbono, fechaInicioMetaCalendar);
				//agregar cuota al detalle
				detalleSimulacion.addCuota(cuota);
				logger.info("Iterando Cuotas: " + cuota);
			}
		} catch (Exception e) {
			logger.error(e);
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
		}
		return detalleSimulacion;
	}
	
/*
	@SuppressWarnings("deprecation")
	private DetalleSimulacion generarCronogramaNPP(ResumenSimulacion resumenSimulacion, BigDecimal tasa, Date fechaInicioMeta) {
		DetalleSimulacion detalleSimulacion = new DetalleSimulacion();
		BigDecimal montoAhorroMesAcumulado = new BigDecimal(0);
		Calendar fechaAbono = Calendar.getInstance();
		Calendar fechaInicioMetaCalendar = Calendar.getInstance();
		fechaInicioMetaCalendar.setTime(fechaInicioMeta);
		fechaAbono.setTime(fechaInicioMeta);
		for (int i = 1; i <= resumenSimulacion.getPlazoAhorroMes(); i++) {
			Cuota cuota = new Cuota();
			cuota.setNumeroCuota(i);
			cuota.setFechaAbono(new Date());
			// fechaAbono = fechaInicioMeta + mes (correlativo).
			BigDecimal montoAhorroMes = new BigDecimal(resumenSimulacion.getMontoAhorroMes());
			BigDecimal montoAbono = montoAhorroMes.add(montoAhorroMesAcumulado);
			BigDecimal interesCuota = new BigDecimal(0);
			BigDecimal montoAhorroCuota = new BigDecimal(0);
			int r = montoAbono.compareTo(new BigDecimal(resumenSimulacion.getMontoMeta()));
			if (r >= 0)
			{
				montoAbono = new BigDecimal(resumenSimulacion.getMontoMeta());
				interesCuota = new BigDecimal(resumenSimulacion.getInteresAhorro());
				montoAhorroCuota = new BigDecimal(resumenSimulacion.getTotalAhorro());
			} else {
				
				// ((((1+tasa%)^(plazoAhorroMes/12)-1)*montoMeta)+montoMeta)
				montoAhorroCuota = (BigDecimal.valueOf(Math.pow(1 + tasa.doubleValue(), (double) i / 12) - 1).multiply(montoAbono)).add(montoAbono);
				interesCuota = montoAhorroCuota.subtract(montoAbono);
				//interesCuota = montoAbono.multiply(tasa);
				//montoAhorroCuota = montoAbono.add(interesCuota);
			}
			cuota.setMontoAbono(redondear(montoAbono.doubleValue(), 2));
			cuota.setInteresCuota(redondear(interesCuota.doubleValue(), 2));
			cuota.setTasa(redondear((tasa.doubleValue() * 100), 2));
			cuota.setMontoAhorroCuota(redondear(montoAhorroCuota.doubleValue(), 2));
			cuota.setFechaAbono(fechaAbono.getTime());
			montoAhorroMesAcumulado = montoAhorroMesAcumulado.add(montoAhorroMes);
			fechaAbono.add(Calendar.MONTH, 1);
			// Control para bisiestos
			if (fechaAbono.get(Calendar.MONTH) == Calendar.FEBRUARY && fechaInicioMetaCalendar.get(Calendar.DATE) >= 29) {
				if ((fechaAbono.get(Calendar.YEAR) % 4 == 0) && ((fechaAbono.get(Calendar.YEAR) % 100 != 0) || (fechaAbono.get(Calendar.YEAR) % 400 == 0)))
					fechaAbono.set(Calendar.DATE, 29);
				else
					fechaAbono.set(Calendar.DATE, 28);
			} else {
				if (fechaAbono.get(Calendar.DATE) != fechaInicioMeta.getDate()){
					fechaAbono.set(Calendar.DATE, fechaInicioMeta.getDate());
				}
			}
			detalleSimulacion.addCuota(cuota);
			logger.info("Iterando Cuotas: " + cuota);

		}

		return detalleSimulacion;
	}
*/
	private boolean isEmptyValue(Object value) 
	{
		if (value == null) 
		{
			return true;
		}
		return value.toString().trim().length() == 0;
	}

	private boolean isNumeric(String value) 
	{
		try 
		{
			Double.parseDouble(value); //NOSONAR
			return true;
		} catch (Exception e) { // NOSONAR
			return false;
		}
	}

	private double redondear(double value, int numeroDecimales) 
	{
		double resultado;
		resultado = value * Math.pow(10, numeroDecimales);
		resultado = Math.round(resultado);
		resultado = resultado / Math.pow(10, numeroDecimales);
		return resultado;
	}
	
	private Calendar calcularFechaAbono(Calendar fecha, Calendar fechaMeta)
	{
		fecha.set(Calendar.DATE, 15);
		fecha.add(Calendar.MONTH, 1);
		//evaluar dia de la meta
		switch (fechaMeta.get(Calendar.DATE))
		{
			case 31 :
					fecha.set(Calendar.DATE, fecha.getActualMaximum(Calendar.DAY_OF_MONTH)); break;
			case 30 :
			case 29 :
					if (fecha.get(Calendar.MONTH) != Calendar.FEBRUARY)
					{
						fecha.set(Calendar.DATE, fechaMeta.get(Calendar.DATE));
					} else {
						fecha.set(Calendar.DATE, fecha.getActualMaximum(Calendar.DAY_OF_MONTH));
					} break;
			default :
					fecha.set(Calendar.DATE, fechaMeta.get(Calendar.DATE));
		}
		/*
		if (fecha.get(Calendar.MONTH) == Calendar.FEBRUARY && fechaMeta.get(Calendar.DATE) >= 29) 
		{
			if ((fecha.get(Calendar.YEAR) % 4 == 0) && ((fecha.get(Calendar.YEAR) % 100 != 0) || (fecha.get(Calendar.YEAR) % 400 == 0)))
			{
				fecha.set(Calendar.DATE, 29);
			} else {
				fecha.set(Calendar.DATE, 28);
			}
		} else {
			if (fecha.get(Calendar.DATE) != fechaMeta.get(Calendar.DATE))
			{
				fecha.set(Calendar.DATE, fechaMeta.get(Calendar.DATE));
			}
		}
		*/
		return fecha;
	}

	private String validate(SimulacionDatos simulacionDatos) 
	{
		String mensajeValidacion = null;
		if (this.isEmptyValue(simulacionDatos.getTipoDocumento())) {
			mensajeValidacion = "Debe informar el Tipo de Documento.";
		} else if (!this.isNumeric(simulacionDatos.getTipoDocumento())) {
			mensajeValidacion = "El Tipo de Documento debe ser numérico.";
		} else if (this.isEmptyValue(simulacionDatos.getNumDocumento())) {
			mensajeValidacion = "Debe informar el Número de Documento.";
		} else if (this.isEmptyValue(simulacionDatos.getCodMeta())) {
			mensajeValidacion = "Debe informar el código de Meta.";
		} else if (!this.isNumeric(simulacionDatos.getCodMeta())) {
			mensajeValidacion = "El Código de Meta debe ser numérico.";
		} else if (this.isEmptyValue(simulacionDatos.getFechaInicioMeta())) {
			mensajeValidacion = "Debe informar el la fecha de incio de ahorro.";
		} else if (this.isEmptyValue(simulacionDatos.getEsCliente())) {
			mensajeValidacion = "Debe informar si es cliente o no.";
		} else if (!("S".equals(simulacionDatos.getEsCliente().trim()) || "N".equals(simulacionDatos.getEsCliente().trim()))) {
			mensajeValidacion = "El campo esCliente solo acepta valores S y N.";
		} else if (!this.isEmptyValue(simulacionDatos.getCentroFinanciero()) && !this.isNumeric(simulacionDatos.getCentroFinanciero())) {
			mensajeValidacion = "El centro financiero representa a un código numérico.";
		} else
		// Se debe enviar al menos el monto de ahorro mensual o el plazo de ahorro
		if (this.isEmptyValue(simulacionDatos.getMontoAhorroMes()) && this.isEmptyValue(simulacionDatos.getPlazoAhorroMes())) {
			mensajeValidacion = "Debe informar el Ahorro Mensual o el Plazo de Ahorro, ambos no pueder ser nulos/vacios.";
		} else if (!this.isEmptyValue(simulacionDatos.getMontoAhorroMes()) && !this.isEmptyValue(simulacionDatos.getPlazoAhorroMes())) {
			mensajeValidacion = "Solo debe enviar el Ahorro Mensual o el Plazo de Ahorro, mas no ambos.";
		} 
		return mensajeValidacion;
	}

}
