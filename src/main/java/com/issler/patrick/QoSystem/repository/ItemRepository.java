package com.issler.patrick.QoSystem.repository;

import java.util.List;

import com.issler.patrick.QoSystem.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.issler.patrick.QoSystem.entity.Categoria;
import com.issler.patrick.QoSystem.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	List<Item> findAllByCategoria(Categoria categoria);
	List<Item> findAllByCategoriaEmpresa(Empresa empresa);

}
