package com.issler.patrick.QoSystem.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "ingrediente")
@Entity
@Component
@Getter @Setter @NoArgsConstructor
public class Ingrediente {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 255, name = "nome")
	private String nome;
	
	@Column(name = "valor")
	private Double valor;

	@ManyToMany
    List<Item> items;
	
}