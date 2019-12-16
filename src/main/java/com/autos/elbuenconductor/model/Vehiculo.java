package com.autos.elbuenconductor.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="VEHICULOS")
public class Vehiculo {
	
	@Id
	private String matricula;
	
	private String marca;
	private String modelo;
	private String color;
	
	@Enumerated(EnumType.STRING)
	private Combustible combustible;
	
	@Temporal(TemporalType.DATE)
	private Date fechaMatriculacion;
	private double coeficiente;
	
	public Vehiculo() {
		
	}

	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;	
	}
	
	public String getModelo() {	
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getColor() {
		return color;	
	}
	
	public void setColor(String color) {
		this.color = color;	
	}
	
	public Combustible getCombustible() {
		return combustible;
	}

	public void setCombustible(Combustible combustible) {
		this.combustible = combustible;
	}

	public Date getFechaMatriculacion() {
		return fechaMatriculacion;
	}
	
	public void setFechaMatriculacion(Date fechaMatriculacion) {	
		this.fechaMatriculacion = fechaMatriculacion;
	}
	
	public double getCoeficiente() {
		return coeficiente;	
	}
	
	public void setCoeficiente(double coeficiente) {
		
		this.coeficiente = coeficiente;
		
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color
				+ ", combustible=" + combustible + ", fechaMatriculacion=" + fechaMatriculacion + ", coeficiente="
				+ coeficiente + "]";
	}

}
