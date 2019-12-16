package com.autos.elbuenconductor.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TRAYECTOS")
public class Trayecto implements Serializable {
	private static final long serialVersionUID = -1L;
	
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "DNI")
	private Cliente cliente; 
	
	@ManyToOne
	@JoinColumn(name = "MATRICULA")
	private Vehiculo vehiculo;
	
	private double kmRecorridos;
	
	private int nAcelerones;
	
	private int nFrenazos;
	
	private double rpmMedias;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date inicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fin;

	public Trayecto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
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
		return "Trayecto [id=" + id + ", cliente=" + cliente + ", vehiculo=" + vehiculo + ", kmRecorridos="
				+ kmRecorridos + ", nAcelerones=" + nAcelerones + ", nFrenazos=" + nFrenazos + ", rpmMedias="
				+ rpmMedias + ", inicio=" + inicio + ", fin=" + fin + "]";
	}

}