package com.autos.elbuenconductor.model;

import java.util.Date;

public class Vehiculo {
	
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	private int nPuertas;
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
	
	public int getnPuertas() {
		
		return nPuertas;
		
	}
	
	public void setnPuertas(int nPuertas) {
		
		this.nPuertas = nPuertas;
		
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
				+ ", nPuertas=" + nPuertas + ", fechaMatriculacion=" + fechaMatriculacion + ", coeficiente="
				+ coeficiente + "]";
	}
	
}
