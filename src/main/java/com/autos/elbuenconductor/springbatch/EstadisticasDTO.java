package com.autos.elbuenconductor.springbatch;

public class EstadisticasDTO {
	
	private String dni;
	private double kmTotales;
	private double kmMedios;
	private int nAceleronesMedios;
	private int nFrenazosMedios;
	private double rpmMedias;
	private String inicioEstadistica;
	private String finEstadistica;
	
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

	public void setKmMedios(double kmRecorridosMedios) {
		this.kmMedios = kmRecorridosMedios;
	}

	public int getnAceleronesMedios() {
		return nAceleronesMedios;
	}

	public void setnAceleronesMedios(int nAceleronesMedios) {
		this.nAceleronesMedios = nAceleronesMedios;
	}

	public int getnFrenazosMedios() {
		return nFrenazosMedios;
	}

	public void setnFrenazosMedios(int nFrenazosMedios) {
		this.nFrenazosMedios = nFrenazosMedios;
	}

	public double getRpmMedias() {
		return rpmMedias;
	}

	public void setRpmMedias(double rpmMedias) {
		this.rpmMedias = rpmMedias;
	}

	public String getInicioEstadistica() {
		return inicioEstadistica;
	}

	public void setInicioEstadistica(String inicioEstadistica) {
		this.inicioEstadistica = inicioEstadistica;
	}

	public String getFinEstadistica() {
		return finEstadistica;
	}

	public void setFinEstadistica(String finEstadistica) {
		this.finEstadistica = finEstadistica;
	}

	@Override
	public String toString() {
		return "EstadisticasDTO [dni=" + dni + ", kmTotales=" + kmTotales + ", kmMedios=" + kmMedios
				+ ", nAceleronesMedios=" + nAceleronesMedios + ", nFrenazosMedios=" + nFrenazosMedios + ", rpmMedias="
				+ rpmMedias + ", inicioEstadistica=" + inicioEstadistica + ", finEstadistica=" + finEstadistica + "]";
	}

}
