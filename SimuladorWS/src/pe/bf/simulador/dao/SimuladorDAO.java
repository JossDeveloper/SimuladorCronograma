package pe.bf.simulador.dao;

import java.security.SignatureException;
import java.sql.Types;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import pe.bf.simulador.bean.RespuestaSimulador;
import pe.bf.simulador.bean.ResumenSimulacion;
import pe.bf.simulador.bean.SimulacionDatos;

public class SimuladorDAO extends BaseDAO {
	private static final Logger logger = Logger.getLogger(SimuladorDAO.class);
	private static final String SQL_REGISTRAR_SIMULACION = "{CALL OWNER.PAKCAGE.USP_REGISTRAR_SIMULACION(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	private static final String SQL_GET_TASAEFECTIVAANUAL = "{CALL ? := OWNER.PAKCAGE.FN_GET_TASAEFECTIVAANUAL(?)}";
	private static final String SQL_GET_MAX_MESESSIMULACION = "{CALL ? := OWNER.PAKCAGE.FN_GET_MAX_MESESSIMULACION(?)}";

	public SimuladorDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * Establece el datasource a utilizar
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;

	}
	/**
	 * Devuelve la tasa efectivo anual de determinado producto de ahorro.
	 *
	 * @param codigoProducto
	 * @return
	 * @throws SignatureException
	 */

	public double getTasaNuevoProductoPasivo(int codigoProducto) throws SignatureException {
		double tasa = 0;
		try {
			connection = dataSource.getConnection();
			callableStatement = connection.prepareCall(SQL_GET_TASAEFECTIVAANUAL);
			callableStatement.registerOutParameter(1, Types.NUMERIC);
			callableStatement.setInt(2, codigoProducto);
			callableStatement.execute();
			tasa = callableStatement.getDouble(1);

		} catch (Exception e) {
			logger.error(e);
			throw new SignatureException(e);
		} finally {
			closeAllResources();
		}
		return tasa;
	}

	/**
	 * Devuelve el numero maximo de meses aplicable a simulacion.
	 *
	 * @param parametro
	 * @return
	 * @throws SignatureException
	 */

	public int getMaximoMesesSimulacion(String parametro) throws SignatureException {
		int meses = 0;
		try {
			connection = dataSource.getConnection();
			callableStatement = connection.prepareCall(SQL_GET_MAX_MESESSIMULACION);
			callableStatement.registerOutParameter(1, Types.NUMERIC);
			callableStatement.setString(2, parametro);
			callableStatement.execute();
			meses = callableStatement.getInt(1);

		} catch (Exception e) {
			logger.error(e);
			throw new SignatureException(e);
		} finally {
			closeAllResources();
		}
		return meses;
	}
	
	/**
	 * Registra los datos de la simulacion en la base de datos.
	 *
	 * @param simulacionDatos
	 * @param resumenSimulacion
	 * @return
	 * @throws SignatureException
	 */
	public RespuestaSimulador grabarNuevoProductoPasivo(SimulacionDatos simulacionDatos, ResumenSimulacion resumenSimulacion) throws SignatureException {
		RespuestaSimulador respuestaBean;
		try {
			int index = 0;
			connection = dataSource.getConnection();
			callableStatement = connection.prepareCall(SQL_REGISTRAR_SIMULACION);
			callableStatement.setInt(++index, simulacionDatos.getCodProducto());
			callableStatement.setInt(++index, Integer.parseInt(simulacionDatos.getTipoDocumento()));
			callableStatement.setString(++index, simulacionDatos.getNumDocumento());
			callableStatement.setString(++index, simulacionDatos.getEsCliente());
			callableStatement.setInt(++index, Integer.parseInt(simulacionDatos.getCodMeta()));
			callableStatement.setString(++index, simulacionDatos.getDscMeta());
			callableStatement.setDouble(++index, simulacionDatos.getMontoMeta());
			callableStatement.setDate(++index, new java.sql.Date(simulacionDatos.getFechaInicioMeta().getTime()));
			callableStatement.setString(++index, simulacionDatos.obtenerTipoSimulacion());
			callableStatement.setDouble(++index, simulacionDatos.getMontoAhorroMes());
			callableStatement.setDouble(++index, simulacionDatos.getPlazoAhorroMes());
			callableStatement.setDouble(++index, resumenSimulacion.getTotalAhorro());
			callableStatement.setDouble(++index, resumenSimulacion.getInteresAhorro());
			callableStatement.setString(++index, simulacionDatos.getUsuarioBF());
			callableStatement.setString(++index, simulacionDatos.getCentroFinanciero());
			callableStatement.setString(++index, simulacionDatos.getCorrelativoNoCliente());

			callableStatement.registerOutParameter(++index, Types.NUMERIC);// 17
			callableStatement.registerOutParameter(++index, Types.VARCHAR);// 18
			callableStatement.registerOutParameter(++index, Types.VARCHAR);// 19
			callableStatement.executeUpdate();
			respuestaBean = new RespuestaSimulador();
			respuestaBean.setCorrelativoNocliente(callableStatement.getString(17));
			respuestaBean.setCodRespuesta(callableStatement.getString(18));
			respuestaBean.setMsgRespuesta(callableStatement.getString(19));

		} catch (Exception e) {
			logger.error(e);
			throw new SignatureException(e);
		} finally {
			closeAllResources();
		}
		return respuestaBean;
	}

}
