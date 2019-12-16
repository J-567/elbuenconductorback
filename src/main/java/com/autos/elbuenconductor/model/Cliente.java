package com.autos.elbuenconductor.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="clientes")
public class Cliente {
	
	@Id
	private String DNI;
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String zipCode;
	private Date fechaNacimiento;
	private Date fechaCarnet;
	private int calidadConduccion;
	
	//Constructor
	public Cliente() {
		
	}

	//Getters
	public String getDNI() {return DNI;}

	public String getNombre() {return nombre;}

	public String getApellido1() {return apellido1;}

	public String getApellido2() {return apellido2;}

	public String getZipCode() {return zipCode;}

	public Date getFechaNacimiento() {return fechaNacimiento;}

	public Date getFechaCarnet() {return fechaCarnet;}

	public int getCalidadConduccion() {return calidadConduccion;}

	//Setters
	public void setDNI(String dNI) {DNI = dNI;}

	public void setNombre(String nombre) {this.nombre = nombre;}

	public void setApellido1(String apellido1) {this.apellido1 = apellido1;}

	public void setApellido2(String apellido2) {this.apellido2 = apellido2;}

	public void setZipCode(String zipCode) {this.zipCode = zipCode;}

	public void setFechaNacimiento(Date fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}

	public void setFechaCarnet(Date fechaCarnet) {this.fechaCarnet = fechaCarnet;}

	public void setCalidadConduccion(int calidadConduccion) {this.calidadConduccion = calidadConduccion;}

	//ToString

	@Override
	public String toString() {
		return "Cliente [DNI=" + DNI + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", zipCode=" + zipCode + ", fechaNacimiento=" + fechaNacimiento + ", fechaCarnet=" + fechaCarnet
				+ ", calidadConduccion=" + calidadConduccion + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
