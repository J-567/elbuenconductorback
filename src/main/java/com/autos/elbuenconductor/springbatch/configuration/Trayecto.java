package com.autos.elbuenconductor.springbatch.configuration;

import java.io.Serializable;
import java.util.Date;

public class Trayecto implements Serializable {
	private static final long serialVersionUID = -1L;
	
	//@Id
	private Long id;
	private String matricula;
	private double kmRecorridos;
	private int nAcelerones;
	private int nFrenazos;
	private double rpmMedias;
	private Date inicio;
	private Date fin;

	public Trayecto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Trayecto [id=" + id + ", matricula=" + matricula + ", kmRecorridos=" + kmRecorridos + ", nAcelerones="
				+ nAcelerones + ", nFrenazos=" + nFrenazos + ", rpmMedias=" + rpmMedias + ", inicio=" + inicio
				+ ", fin=" + fin + "]";
	}

}