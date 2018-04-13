package pe.bf.simulador.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class BaseDAO {
	private final Logger logger = Logger.getLogger(BaseDAO.class);

	protected Connection connection = null;
	protected PreparedStatement preparedStatement = null;
	protected CallableStatement callableStatement = null;
	protected ResultSet resultSet = null;
	protected DataSource dataSource = null;

	protected void closeAllResources() {
		this.closeResultSet();
		this.closePreparedStatement();
		this.closeCallableStatement();
		this.closeConnection();
	}

	protected void clearDataSource() {
		this.closeDataSource();
	}

	private void closeConnection() {
		if (null != connection) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				logger.error(e, e.fillInStackTrace());
			} catch (Exception e) {
				logger.error(e, e.fillInStackTrace());
			}
		}
	}

	private void closePreparedStatement() {
		if (null != preparedStatement) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				logger.error(e, e.fillInStackTrace());
			}
		}
	}

	private void closeCallableStatement() {
		if (null != callableStatement) {
			try {
				callableStatement.close();
			} catch (SQLException e) {
				logger.error(e, e.fillInStackTrace());
			}
		}
	}

	private void closeResultSet() {
		if (null != resultSet) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				logger.error(e, e.fillInStackTrace());
			}
		}
	}

	private void closeDataSource() {
		if (null != dataSource) {
			try {
				dataSource = null;
			} catch (Exception e) {
				logger.error(e, e.fillInStackTrace());
			}
		}
	}
}
