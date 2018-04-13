package pe.bf.simulador.bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;

public class Cuota {
    private int numeroCuota;
    @XmlElement
    @XmlSchemaType(name="date")
    private Date fechaAbono;
    private double montoAbono;
    private double interesCuota;
    private double tasa;
    private double montoAhorroCuota;

    public Cuota() {
    	//Default empty constructor
    }

    public int getNumeroCuota() {
	return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
	this.numeroCuota = numeroCuota;
    }

    public Date getFechaAbono() {
	return fechaAbono;
    }

    public void setFechaAbono(Date fechaAbono) {
	this.fechaAbono = fechaAbono;
    }

    public double getMontoAbono() {
	return montoAbono;
    }

    public void setMontoAbono(double montoAbono) {
	this.montoAbono = montoAbono;
    }

    public double getInteresCuota() {
	return interesCuota;
    }

    public void setInteresCuota(double interesCuota) {
	this.interesCuota = interesCuota;
    }

    public double getTasa() {
	return tasa;
    }

    public void setTasa(double tasa) {
	this.tasa = tasa;
    }

    public double getMontoAhorroCuota() {
	return montoAhorroCuota;
    }

    public void setMontoAhorroCuota(double montoAhorroCuota) {
	this.montoAhorroCuota = montoAhorroCuota;
    }

    @Override
    public String toString() {
	return String.format("Cuota [numeroCuota=%s, fechaAbono=%s, montoAbono=%s, interesCuota=%s, tasa=%s, montoAhorroCuota=%s]", numeroCuota, fechaAbono, montoAbono, interesCuota, tasa, montoAhorroCuota);
    }

}
