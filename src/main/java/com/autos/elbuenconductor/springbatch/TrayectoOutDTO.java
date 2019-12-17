package com.autos.elbuenconductor.springbatch;

import java.util.Date;

public class TrayectoOutDTO {

	private Long id;
	private String dni;
	private String matricula;
	private double kmRecorridos;
	private int nAcelerones;
	private int nFrenazos;
	private double rpmMedias;
	private Date inicio;
	private Date fin;
	private double precio;
	
	public TrayectoOutDTO(){
		
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
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


	public int getnAcelerones() {
		return nAcelerones;
	}


	public void setnAcelerones(int nAcelerones) {
		this.nAcelerones = nAcelerones;
	}


	public int getnFrenazos() {
		return nFrenazos;
	}


	public void setnFrenazos(int nFrenazos) {
		this.nFrenazos = nFrenazos;
	}


	public double getRpmMedias() {
		return rpmMedias;
	}


	public void setRpmMedias(double rpmMedias) {
		this.rpmMedias = rpmMedias;
	}


	public Date getInicio() {
		return inicio;
	}


	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}


	public Date getFin() {
		return fin;
	}


	public void setFin(Date fin) {
		this.fin = fin;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "TrayectoOutDTO [id=" + id + ", dni=" + dni + ", matricula=" + matricula + ", kmRecorridos="
				+ kmRecorridos + ", nAcelerones=" + nAcelerones + ", nFrenazos=" + nFrenazos + ", rpmMedias="
				+ rpmMedias + ", inicio=" + inicio + ", fin=" + fin + ", precio=" + precio + "]";
	}
	
}
