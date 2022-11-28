package com.issler.patrick.QoSystem.entity;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	@JsonIgnore
	@ManyToMany( cascade = CascadeType.PERSIST)
	@JoinTable(name = "ingrediente_item",
			joinColumns = @JoinColumn(name = "ingrediente_id"),
			inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;

	@JsonIgnore
	@OneToMany(mappedBy = "ingrediente", cascade = CascadeType.PERSIST)
	private List<Adicional> adicionais;

	@JsonIgnore
	@OneToMany(mappedBy = "ingrediente", cascade = CascadeType.PERSIST)
	private List<Remover> remover;

	@Column(name = "adicional")
	private Boolean adicional;

	@Column(name = "quantidade")
	private Integer quantidade;

	@Column(name = "medida")
	private String medida;

}