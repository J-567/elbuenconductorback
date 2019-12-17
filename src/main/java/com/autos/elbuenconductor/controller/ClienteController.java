package com.autos.elbuenconductor.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autos.elbuenconductor.model.Cliente;
import com.autos.elbuenconductor.repositories.ClienteRepository;

@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes/{dni}")
	public Optional<Cliente> getClienteByDni(@PathVariable ("dni") String dni) {
		return clienteRepository.findById(dni);
	}

}
