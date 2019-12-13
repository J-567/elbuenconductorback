package com.autos.elbuenconductor.springbatch.configuration;

import java.io.Serializable;

public class Trayecto implements Serializable {
	private static final long serialVersionUID = -1L;
	
	private Long id;
	private String matricula;
	private String kmRecorridos;
	private int nAcelerones;
	private int nFrenazos;
	private double rpmMedias;

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

	public String getKmRecorridos() {
		return kmRecorridos;
	}

	public void setKmRecorridos(String kmRecorridos) {
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
	
	
}