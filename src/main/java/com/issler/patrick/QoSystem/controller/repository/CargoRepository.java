package com.issler.patrick.QoSystem.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.issler.patrick.QoSystem.entity.Cargo;


@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> { 
	
}
