package pe.bf.simulador.ejb;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class BaseEJB {

	@Resource(name = "jdbc/datasource")
	protected DataSource datasource;

	public BaseEJB() {
		//Default empty contructor
	}

}
