package com.autos.elbuenconductor.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.autos.elbuenconductor.model.Cliente;
import com.autos.elbuenconductor.model.Trayecto;

@Repository
public interface TrayectoRepository extends JpaRepository<Trayecto, Long>{

	public List<Trayecto> findByCliente(Cliente cliente);
	
	public List<Trayecto> findByClienteAndInicioBetweenAndFinBetween(Cliente cliente, Date inicio, Date fin, Date inicio2, Date fin2);
	
	@Query("select t from Trayecto t where t.cliente = :cliente AND (t.inicio > :inicio AND t.inicio < :fin) AND (t.fin > :inicio AND t.fin < :fin)") // JPQL
	public List<Trayecto> findByClienteAndDatesBetween (@Param("cliente") 	Cliente cliente, 
														@Param("inicio")	Date inicio, 
														@Param("fin") 		Date fin);
	
	
	// Lista de deseos....
	
	//Servicio
	//TODO Cálculo del precio de un trayectos
	
	//****DATOS CLIENTE****:
	//DATOS PERSONALES:
	//TODO ENDPOINT getClienteById<Cliente>
	
	//DATOS DE UN TRAYECTO:
	//TODO ENDPOINT trayecto por id y por cliente<Trayecto>
	
	//NEXT STEP, SI NUESTROS TRAYECTOS FUESEN SERIES TEMPORALES ENDPOINT Series temporales (para hacer gráficos)
	
	//ESTADÍSTICAS GENERALES:
	//TODO ENDPOINT Estadísticas entre dos fechas: nTrayectos y valores medios de rmp, nFrenazos, nAcelerones, Km (por trayecto) 
	//{'rpm': val, 'nFren': val, 'nAc': val, 'nTray': val, 'KmMedios': val, TotalGAstado': val} crear modelo DTOs
	
	//Detalle de las estadísticas:
	//TODO ENDPOINT numero de trayectos realizados y con qué coches entre dos fechas(data struct {"matrícula"; number})
	
	//****DATOS VEHICULOS****:
	//TODO ENDPOINT findVehiculoById<Vehiculo>
	
	//TODO ENDPOINT buscador/lista de vehiculo<Vehiculo[]>
	

}
