package com.autos.elbuenconductor.springbatch;

import java.util.Date;

public class VehiculoDTO {
	
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	private int nPuertas;
	private String fechaMatriculacion;
	private double coeficiente;
	
	public VehiculoDTO() {
		
		
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
	
	public String getFechaMatriculacion() {
		
		return fechaMatriculacion;
		
	}
	
	public void setFechaMatriculacion(String fechaMatriculacion) {
		
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


