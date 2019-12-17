package com.autos.elbuenconductor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autos.elbuenconductor.model.Vehiculo;
import com.autos.elbuenconductor.repositories.VehiculoRepository;

@RestController
@RequestMapping("/api")
public class VehiculoController {

	@Autowired
	public VehiculoRepository vehiculoRepository;

	//Endpoint para ver todos los vehiculos disponibles
	@GetMapping("/vehiculos")
	public List <Vehiculo> getAllVehiculos(){
		return vehiculoRepository.findAll();
	}
	
	//Endpoint para ver un vehiculo por su matricula
	@GetMapping ("/vehiculos/{matricula}")
	public Optional<Vehiculo> getById(@PathVariable ("matricula") String matricula) {
		return vehiculoRepository.findById(matricula);
	}
	
	
}
