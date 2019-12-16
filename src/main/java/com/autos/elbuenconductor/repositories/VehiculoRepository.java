package com.autos.elbuenconductor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autos.elbuenconductor.model.Vehiculo;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, String>{

}
