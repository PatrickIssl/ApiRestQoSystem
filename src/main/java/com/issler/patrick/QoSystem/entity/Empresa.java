package com.issler.patrick.QoSystem.entity;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "empresa")
@Entity
@Component
@Getter
@Setter
@NoArgsConstructor
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "razao_social")
	private String razaoSocial;

	@Column(name = "telefone", length = 20)
	private String telefone;

	@Column(name = "cnpj", length = 30)
	private String cnpj;

	@OneToOne()
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@OneToMany(mappedBy = "empresa")
	private List<Cargo> cargos;

	@OneToMany(mappedBy = "empresa")
	private List<Categoria> categorias;

}