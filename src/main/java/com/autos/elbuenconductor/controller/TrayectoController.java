package com.autos.elbuenconductor.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.autos.elbuenconductor.model.Cliente;
import com.autos.elbuenconductor.model.Trayecto;
import com.autos.elbuenconductor.repositories.TrayectoRepository;

@RestController
@RequestMapping("/api")
public class TrayectoController {
	
	@Autowired	
	private TrayectoRepository trayectoRepository;
	
	@GetMapping("/clientes/{dni}/{id}")
	public Optional<Trayecto> getByDniById(@PathVariable ("dni") String dni,
								 		   @PathVariable ("id") Long id){
		
		Cliente cliente = new Cliente();
		cliente.setDNI(dni);
	
		return trayectoRepository.findByClienteAndId(cliente, id);			   
	}
	
	@GetMapping("/clientes/{dni}/{inicio}/{fin}")
	public List<Trayecto> getByDniBetweenInicioFin(@PathVariable ("dni") String dni,
	 		   									   @PathVariable ("inicio") String inicioStr,
	 		   									   @PathVariable ("fin") String finStr) throws ParseException{
		
		Cliente cliente = new Cliente();
		cliente.setDNI(dni);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		Date inicio = sdf.parse(inicioStr);
		Date fin = sdf.parse(finStr);
		
		return trayectoRepository.findByClienteAndDatesBetween(cliente, inicio, fin);
	}
	
	
	/*
	@GetMapping("/test")
	public String test() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Cliente cliente = new Cliente();
		cliente.setDNI("12345678A");
		
		Date date1 = sdf.parse("12/12/2019");
		Date date2 = sdf.parse("15/12/2019");
		
		List<Trayecto> trayectos = trayectoRepository.findByClienteAndDatesBetween(cliente,date1, date2);
		
		System.out.println("RESULTADOS **************************************************************");
		trayectos.stream().forEach(x -> {
			System.out.println(x);
		});
		
		
		return "ok";
	}
	*/
	
}
