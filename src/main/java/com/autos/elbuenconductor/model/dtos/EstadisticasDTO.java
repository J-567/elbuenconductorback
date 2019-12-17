package com.autos.elbuenconductor.model.dtos;

import java.util.Date;

public class EstadisticasDTO {
	
	private String dni;
	private double kmTotales;
	private double kmMedios;
	private double nAceleronesMedios;
	private double nFrenazosMedios;
	private double rpmMedias;
	private Date inicioEstadistica;
	private Date finEstadistica;
	private int nTrayectos;
	
	public EstadisticasDTO() {
		
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public double getKmTotales() {
		return kmTotales;
	}

	public void setKmTotales(double kmTotales) {
		this.kmTotales = kmTotales;
	}

	public double getKmMedios() {
		return kmMedios;
	}

	public void setKmMedios(double kmMedios) {
		this.kmMedios = kmMedios;
	}

	public double getnAceleronesMedios() {
		return nAceleronesMedios;
	}

	public void setnAceleronesMedios(double nAceleronesMedios) {
		this.nAceleronesMedios = nAceleronesMedios;
	}

	public double getnFrenazosMedios() {
		return nFrenazosMedios;
	}

	public void setnFrenazosMedios(double nFrenazosMedios) {
		this.nFrenazosMedios = nFrenazosMedios;
	}

	public double getRpmMedias() {
		return rpmMedias;
	}

	public void setRpmMedias(double rpmMedias) {
		this.rpmMedias = rpmMedias;
	}

	public Date getInicioEstadistica() {
		return inicioEstadistica;
	}

	public void setInicioEstadistica(Date inicioEstadistica) {
		this.inicioEstadistica = inicioEstadistica;
	}

	public Date getFinEstadistica() {
		return finEstadistica;
	}

	public void setFinEstadistica(Date finEstadistica) {
		this.finEstadistica = finEstadistica;
	}

	public int getnTrayectos() {
		return nTrayectos;
	}

	public void setnTrayectos(int nTrayectos) {
		this.nTrayectos = nTrayectos;
	}

	@Override
	public String toString() {
		return "EstadisticasDTO [dni=" + dni + ", kmTotales=" + kmTotales + ", kmMedios=" + kmMedios
				+ ", nAceleronesMedios=" + nAceleronesMedios + ", nFrenazosMedios=" + nFrenazosMedios + ", rpmMedias="
				+ rpmMedias + ", inicioEstadistica=" + inicioEstadistica + ", finEstadistica=" + finEstadistica
				+ ", nTrayectos=" + nTrayectos + "]";
	}

}
