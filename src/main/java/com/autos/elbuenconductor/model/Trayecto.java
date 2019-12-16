package com.autos.elbuenconductor.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Trayectos")
public class Trayecto {
	@Id
	private int id;
	private String matricula;
	private String kmRecorridos;
	private int nAcelerones;
	private int nFrenazos;
	private double rpmMedias;
	
	public Trayecto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	@Override
	public String toString() {
		return "Trayecto [id=" + id + ", matricula=" + matricula + ", kmRecorridos=" + kmRecorridos + ", nAcelerones="
				+ nAcelerones + ", nFrenazos=" + nFrenazos + ", rpmMedias=" + rpmMedias + "]";
	}
	
}
