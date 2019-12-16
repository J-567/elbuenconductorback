package com.autos.elbuenconductor.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
	
	@GetMapping("/clientes/{dni}/trayectos")
	public List<Trayecto> getByDni(@PathVariable ("dni") String dni){
		
		Cliente cliente = new Cliente();
		cliente.setDNI(dni);
	
		return trayectoRepository.findByCliente(cliente);			   
	}
	
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
	
	
}
