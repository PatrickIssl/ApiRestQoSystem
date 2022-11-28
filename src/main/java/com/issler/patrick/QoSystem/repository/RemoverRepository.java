package com.issler.patrick.QoSystem.repository;

import com.issler.patrick.QoSystem.entity.Adicional;
import com.issler.patrick.QoSystem.entity.Remover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RemoverRepository extends JpaRepository<Remover, Long> {
	
}
