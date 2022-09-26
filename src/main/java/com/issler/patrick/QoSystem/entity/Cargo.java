package com.issler.patrick.QoSystem.entity;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "cargo")
@Entity
@Component
@Getter
@Setter
@NoArgsConstructor
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@ManyToOne()
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;


	@OneToMany(mappedBy = "cargo")
	private List<Pessoa> pessoas;

}