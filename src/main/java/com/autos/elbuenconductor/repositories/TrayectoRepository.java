package com.autos.elbuenconductor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autos.elbuenconductor.model.Trayecto;

@Repository
public interface TrayectoRepository extends JpaRepository<Trayecto, Long>{

}
