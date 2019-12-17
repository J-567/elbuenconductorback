package com.autos.elbuenconductor.springbatch;

public class EstadisticasByCocheDTO {

	private String dni;
	private double kmRecorridos;
	private int numeroTrayectos;
	private String inicioEstadistica;
	private String finEstadistica;
	
	public EstadisticasByCocheDTO() {
		
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public double getKmRecorridos() {
		return kmRecorridos;
	}
	
	public void setKmRecorridos(double kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}
	
	public int getNumeroTrayectos() {
		return numeroTrayectos;
	}
	
	public void setNumeroTrayectos(int numeroTrayectos) {
		this.numeroTrayectos = numeroTrayectos;
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
		return "DatosByCocheDTO [dni=" + dni + ", kmRecorridos=" + kmRecorridos + ", numeroTrayectos=" + numeroTrayectos
				+ ", inicioEstadistica=" + inicioEstadistica + ", finEstadistica=" + finEstadistica + "]";
	}
	
}
