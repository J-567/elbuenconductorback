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
		
		this.vehiculoRepository.save(v1);
		
		
	}
	
	@Bean
	public void generateClientes() throws ParseException {
		
		Cliente c1 = new Cliente();
		c1.setDNI("12345678A");
		c1.setNombre("José Ramón");
		c1.setApellido1("Vilchez");
		c1.setApellido2("Recalde");
		c1.setFechaCarnet(sdf.parse("08/12/2004"));
		c1.setFechaNacimiento(sdf.parse("23/07/1984"));
		c1.setZipCode("08070");
		c1.setCalidadConduccion(7);
		
		this.clienteRepository.save(c1);
		
		
	}
	
	
	
}
