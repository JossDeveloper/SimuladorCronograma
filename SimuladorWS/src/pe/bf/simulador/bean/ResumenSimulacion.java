package pe.bf.simulador.bean;

public class ResumenSimulacion {
	private int codProducto;
	private double montoMeta;
	private double montoAhorroMes;
	private int plazoAhorroMes;
	private double interesAhorro;
	private double totalAhorro;

	public ResumenSimulacion() {
		//Default empty constructor
	}

	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public double getMontoMeta() {
		return montoMeta;
	}

	public void setMontoMeta(double montoMeta) {
		this.montoMeta = montoMeta;
	}

	public double getMontoAhorroMes() {
		return montoAhorroMes;
	}

	public void setMontoAhorroMes(double montoAhorroMes) {
		this.montoAhorroMes = montoAhorroMes;
	}

	public int getPlazoAhorroMes() {
		return plazoAhorroMes;
	}

	public void setPlazoAhorroMes(int plazoAhorroMes) {
		this.plazoAhorroMes = plazoAhorroMes;
	}

	public double getInteresAhorro() {
		return interesAhorro;
	}

	public void setInteresAhorro(double interesAhorro) {
		this.interesAhorro = interesAhorro;
	}

	public double getTotalAhorro() {
		return totalAhorro;
	}

	public void setTotalAhorro(double totalAhorro) {
		this.totalAhorro = totalAhorro;
	}

	@Override
	public String toString() {
		return String.format("ResumenSimulacion [codProducto=%s, montoMeta=%s, montoAhorroMes=%s, plazoAhorroMes=%s, interesAhorro=%s, totalAhorro=%s]", codProducto, montoMeta, montoAhorroMes, plazoAhorroMes, interesAhorro, totalAhorro);
	}

}
