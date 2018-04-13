package pe.bf.simulador.bean;

import java.util.ArrayList;
import java.util.List;

public class DetalleSimulacion {
	private List<Cuota> cronograma;

	public DetalleSimulacion() {
		//Default empty constructor
	}

	public List<Cuota> getCronograma() {
		if (cronograma == null) {
			cronograma = new ArrayList<Cuota>();
		}
		return cronograma;
	}

	public void setCronograma(List<Cuota> cronograma) {
		this.cronograma = cronograma;
	}

	public void addCuota(Cuota cuota) {
		this.getCronograma().add(cuota);
	}

	@Override
	public String toString() {
		return String.format("RespuestaSimulador [cronograma=%s]", cronograma);
	}
}
