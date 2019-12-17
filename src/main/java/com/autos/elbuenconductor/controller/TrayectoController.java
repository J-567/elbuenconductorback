package com.autos.elbuenconductor.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api")
public class TrayectoController {
	
	@Autowired	
	private TrayectoRepository trayectoRepository;
	
	//Servicios:
	public double getPrecioOptional(Optional<Trayecto> trayecto) {
		
		return trayecto.get().getKmRecorridos()*
				(0.06 + 0.01*trayecto.get().getVehiculo().getCoeficiente()
				- 0.001*trayecto.get().getCliente().getCalidadConduccion());
		
	}
	
	public double getPrecio(Trayecto trayecto) {
		
		return trayecto.getKmRecorridos()*
				(0.06 + 0.01*trayecto.getVehiculo().getCoeficiente()
				- 0.001*trayecto.getCliente().getCalidadConduccion());
	}
	
	
	@GetMapping("/clientes/{dni}/{id}")
	public TrayectoOutDTO getByDniById(@PathVariable ("dni") String dni,
								 		   @PathVariable ("id") Long id){
		
		Cliente cliente = new Cliente();
		cliente.setDNI(dni);
	
		Optional<Trayecto> trayecto = trayectoRepository.findByClienteAndId(cliente, id);
		
		TrayectoOutDTO trayectoOut = new TrayectoOutDTO();
		
		trayectoOut.setId(trayecto.get().getId());
		trayectoOut.setDni(trayecto.get().getCliente().getDNI());
		trayectoOut.setMatricula(trayecto.get().getVehiculo().getMatricula());
		trayectoOut.setKmRecorridos(trayecto.get().getKmRecorridos());
		trayectoOut.setnAcelerones(trayecto.get().getnAcelerones());
		trayectoOut.setnFrenazos(trayecto.get().getnFrenazos());
		trayectoOut.setRpmMedias(trayecto.get().getRpmMedias());
		trayectoOut.setInicio(trayecto.get().getInicio());
		trayectoOut.setFin(trayecto.get().getFin());
		trayectoOut.setPrecio(this.getPrecioOptional(trayecto));
		
		return trayectoOut;			   
	}
	
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
			trayectoOut.setPrecio(this.getPrecio(trayecto));
			
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
