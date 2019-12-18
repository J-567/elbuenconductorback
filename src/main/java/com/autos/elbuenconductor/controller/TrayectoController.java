package com.autos.elbuenconductor.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.autos.elbuenconductor.model.Cliente;
import com.autos.elbuenconductor.model.Trayecto;
import com.autos.elbuenconductor.model.dtos.EstadisticasByCocheDTO;
import com.autos.elbuenconductor.model.dtos.EstadisticasDTO;
import com.autos.elbuenconductor.model.dtos.TrayectoOutDTO;
import com.autos.elbuenconductor.repositories.TrayectoRepository;
import com.autos.elbuenconductor.services.CalculosServices;

@RestController
@RequestMapping("/api")
public class TrayectoController {
	
	@Autowired	
	private TrayectoRepository trayectoRepository;
	
	@Autowired
	private CalculosServices calculoServices;
	
	@CrossOrigin()
	@GetMapping("/clientes/{dni}/{id}")
	public TrayectoOutDTO getByDniById(@PathVariable ("dni") String dni,
								 		   @PathVariable ("id") Long id){
		
		Cliente cliente = new Cliente();
		cliente.setDNI(dni);
	
		Optional<Trayecto> optional = trayectoRepository.findByClienteAndId(cliente, id);
		
		Trayecto trayecto = optional.isPresent()? optional.get():null;
		
		TrayectoOutDTO trayectoOut = null;
		
		if(trayecto != null) {

			trayectoOut = new TrayectoOutDTO();
			
			trayectoOut.setId(trayecto.getId());
			trayectoOut.setDni(trayecto.getCliente().getDNI());
			trayectoOut.setMatricula(trayecto.getVehiculo().getMatricula());
			trayectoOut.setKmRecorridos(trayecto.getKmRecorridos());
			trayectoOut.setnAcelerones(trayecto.getnAcelerones());
			trayectoOut.setnFrenazos(trayecto.getnFrenazos());
			trayectoOut.setRpmMedias(trayecto.getRpmMedias());
			trayectoOut.setInicio(trayecto.getInicio());
			trayectoOut.setFin(trayecto.getFin());
			trayectoOut.setPrecio(this.calculoServices.getPrecioTrayecto(trayecto));
		
		}
		
		return trayectoOut;			   
	}
	
	@CrossOrigin()
	@GetMapping("/clientes/{dni}/{inicio}/{fin}")
	public List<TrayectoOutDTO> getByDniBetweenInicioFin(@PathVariable ("dni") String dni,
	 		   									   @PathVariable ("inicio") String inicioStr,
	 		   									   @PathVariable ("fin") String finStr) throws ParseException{
		
		Cliente cliente = new Cliente();
		cliente.setDNI(dni);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		Date inicio = sdf.parse(inicioStr);
		Date fin = sdf.parse(finStr);
		
		List<Trayecto> trayectos = trayectoRepository.findByClienteAndDatesBetween(cliente, inicio, fin);
		
		List<TrayectoOutDTO> trayectosOut = new ArrayList<TrayectoOutDTO>();
		
		for(Trayecto trayecto : trayectos) {
			
			TrayectoOutDTO trayectoOut = new TrayectoOutDTO();
			
			trayectoOut.setId(trayecto.getId());
			trayectoOut.setDni(trayecto.getCliente().getDNI());
			trayectoOut.setMatricula(trayecto.getVehiculo().getMatricula());
			trayectoOut.setKmRecorridos(trayecto.getKmRecorridos());
			trayectoOut.setnAcelerones(trayecto.getnAcelerones());
			trayectoOut.setnFrenazos(trayecto.getnFrenazos());
			trayectoOut.setRpmMedias(trayecto.getRpmMedias());
			trayectoOut.setInicio(trayecto.getInicio());
			trayectoOut.setFin(trayecto.getFin());
			trayectoOut.setPrecio(this.calculoServices.getPrecioTrayecto(trayecto));
			
			trayectosOut.add(trayectoOut);
			
		}
		
		return trayectosOut;
	}
	
	@GetMapping("/clientes/{dni}/estadisticas/{inicio}/{fin}")
	public EstadisticasDTO getEstadisticasByDniBetweenInicioFin(
			       @PathVariable ("dni") String dni,
				   @PathVariable ("inicio") String inicioStr,
				   @PathVariable ("fin") String finStr) throws ParseException{
		
		List<TrayectoOutDTO> trayectos = this.getByDniBetweenInicioFin(dni, inicioStr, finStr);
		
		EstadisticasDTO estadisticas = new EstadisticasDTO();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		estadisticas.setInicioEstadistica(sdf.parse(inicioStr));
		estadisticas.setFinEstadistica(sdf.parse(finStr));
		
		estadisticas.setDni(dni);
		
		int numeroTrayectos = trayectos.size();
		estadisticas.setnTrayectos(numeroTrayectos);

		double kmTotales = 0.0;
		double nAceleronesMedios = 0.0;
		double nFrenazosMedios = 0.0;
		double rpmMedias = 0.0;
		
		for(TrayectoOutDTO trayecto : trayectos) {
			
			kmTotales += trayecto.getKmRecorridos();
			nAceleronesMedios += trayecto.getnAcelerones();
			nFrenazosMedios += trayecto.getnFrenazos();
			rpmMedias += trayecto.getRpmMedias();
		
		}
		
		estadisticas.setKmTotales(kmTotales);
		estadisticas.setKmMedios(kmTotales / numeroTrayectos);
		estadisticas.setnAceleronesMedios(nAceleronesMedios / numeroTrayectos);
		estadisticas.setnFrenazosMedios(nFrenazosMedios / numeroTrayectos);
		estadisticas.setRpmMedias(rpmMedias / numeroTrayectos);
				
		return estadisticas;
	}
	
	@GetMapping("/clientes/{dni}/estadisticascoches/{inicio}/{fin}")
	public List<EstadisticasByCocheDTO> getEstadisticasCochesByDniBetweenInicioFin(
			       @PathVariable ("dni") String dni,
				   @PathVariable ("inicio") String inicioStr,
				   @PathVariable ("fin") String finStr) throws ParseException{
		
		List<TrayectoOutDTO> trayectos = this.getByDniBetweenInicioFin(dni, inicioStr, finStr);
		List<String> matriculas =  new ArrayList<String>();
		
		for (TrayectoOutDTO trayecto: trayectos) {
			if (!matriculas.contains(trayecto.getMatricula())){
				matriculas.add(trayecto.getMatricula());
			}
		}
			
		List<EstadisticasByCocheDTO> estadisticasByCoche = new ArrayList<EstadisticasByCocheDTO>();
		
		for (String matricula: matriculas) {
			EstadisticasByCocheDTO estadisticaCoche = new EstadisticasByCocheDTO();
			
			estadisticaCoche.setMatricula(matricula);
		
			List<TrayectoOutDTO> trayectosByCoche = trayectos.stream()
					 				.filter(x -> x.getMatricula().equals(matricula))
					 				.collect(Collectors.toList());
			
			estadisticaCoche.setNumeroTrayectos(trayectosByCoche.size());
			
			estadisticaCoche.setKmRecorridos(trayectosByCoche.stream()
							.collect(Collectors.summingDouble(x -> x.getKmRecorridos())));
			
			estadisticasByCoche.add(estadisticaCoche);
			
		}
		
		return estadisticasByCoche;
	}
	
}
