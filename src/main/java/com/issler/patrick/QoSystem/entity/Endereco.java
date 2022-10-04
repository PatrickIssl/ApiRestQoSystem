package com.issler.patrick.QoSystem.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "endereco")
@Entity
@Component
@Getter
@Setter
@NoArgsConstructor
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "rua", length = 155)
	private String rua;

	@Column(name = "bairro", length = 155)
	private String bairro;

	@Column(name = "numero", length = 155)
	private String numero;

	@Column(name = "uf", length = 2)
	private String uf;

	@Column(name = "pais", length = 155)
	private String pais;

	@Column(name = "observacao", length = 155)
	private String observacao;

	@JsonIgnore
	@OneToOne(mappedBy = "endereco", cascade = CascadeType.PERSIST)
	private Pessoa pessoa;

	@JsonIgnore
	@OneToOne(mappedBy = "endereco", cascade=CascadeType.PERSIST)
	private Empresa empresa;

}