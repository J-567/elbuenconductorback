package com.autos.elbuenconductor.model.dtos;

public class EstadisticasByCocheDTO {

	private String matricula;
	private double kmRecorridos;
	private int numeroTrayectos;
	
	public EstadisticasByCocheDTO() {
		
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	@Override
	public String toString() {
		return "EstadisticasByCocheDTO [matricula=" + matricula + ", kmRecorridos=" + kmRecorridos
				+ ", numeroTrayectos=" + numeroTrayectos + "]";
	}
	
}
