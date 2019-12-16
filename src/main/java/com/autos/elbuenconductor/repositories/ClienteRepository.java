package com.autos.elbuenconductor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autos.elbuenconductor.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
