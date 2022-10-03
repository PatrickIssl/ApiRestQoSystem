package com.issler.patrick.QoSystem.entity;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

	@Column( name = "nome")
	private String nome;
	
	@Column(name = "valor")
	private Double valor;

	@ManyToMany( cascade = CascadeType.ALL)
	@JoinTable(name = "ingrediente_item",
			joinColumns = @JoinColumn(name = "ingrediente_id"),
			inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;

	@JsonIgnore
	@OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL)
	private List<Adicional> adicionais;

}