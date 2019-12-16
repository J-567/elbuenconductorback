package com.autos.elbuenconductor.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.autos.elbuenconductor.model.Cliente;
import com.autos.elbuenconductor.model.Combustible;
import com.autos.elbuenconductor.model.Vehiculo;
import com.autos.elbuenconductor.repositories.ClienteRepository;
import com.autos.elbuenconductor.repositories.VehiculoRepository;

@Configuration
public class DemoDataConfig {

	@Autowired
	private VehiculoRepository vehiculoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Bean
	public void generateVhiculos() throws ParseException {
		
		Vehiculo v1 = new Vehiculo();
		v1.setMatricula("3445DKM");
		v1.setMarca("VOLKSWAGEN");
		v1.setModelo("Golf Plus");
		v1.setColor("gris");
		v1.setCombustible(Combustible.GASOIL);
		v1.setFechaMatriculacion(sdf.parse("10/06/2005"));
		v1.setCoeficiente(1.2);
		
		Vehiculo v2 = new Vehiculo();
		v2.setMatricula("5567JJL");
		v2.setMarca("SEAT");
		v2.setModelo("Ibiza");
		v2.setColor("Rojo");
		v2.setCombustible(Combustible.GASOLINA);
		v2.setFechaMatriculacion(sdf.parse("23/05/2010"));
		v2.setCoeficiente(0.8);
		
		Vehiculo v3 = new Vehiculo();
		v3.setMatricula("1125LLV");
		v3.setMarca("TESLA");
		v3.setModelo("Roadster");
		v3.setColor("Azul");
		v3.setCombustible(Combustible.ELECTRICO);
		v3.setFechaMatriculacion(sdf.parse("04/11/2018"));
		v3.setCoeficiente(1.7);
		
		this.vehiculoRepository.save(v1);
		this.vehiculoRepository.save(v2);
		this.vehiculoRepository.save(v3);
		
	}
	
	@Bean
	public void generateClientes() throws ParseException {
		
		Cliente c1 = new Cliente();
		c1.setDNI("12345678A");
		c1.setNombre("Marina");
		c1.setApellido1("Hernández");
		c1.setApellido2("Huertas");
		c1.setFechaCarnet(sdf.parse("04/05/1990"));
		c1.setFechaNacimiento(sdf.parse("12/03/1971"));
		c1.setZipCode("08013");
		c1.setCalidadConduccion(9);
		
		Cliente c2 = new Cliente();
		c2.setDNI("87654321V");
		c2.setNombre("José Ramón");
		c2.setApellido1("Vilchez");
		c2.setApellido2("Recalde");
		c2.setFechaCarnet(sdf.parse("08/12/2004"));
		c2.setFechaNacimiento(sdf.parse("23/07/1984"));
		c2.setZipCode("08070");
		c2.setCalidadConduccion(7);
		
		Cliente c3 = new Cliente();
		c3.setDNI("44678910Y");
		c3.setNombre("Juan");
		c3.setApellido1("Ramírez");
		c3.setApellido2("García");
		c3.setFechaCarnet(sdf.parse("28/01/2010"));
		c3.setFechaNacimiento(sdf.parse("10/05/1990"));
		c3.setZipCode("08015");
		c3.setCalidadConduccion(2);
		
		this.clienteRepository.save(c1);
		this.clienteRepository.save(c2);
		this.clienteRepository.save(c3);
		
		
	}
	
	
	
}
