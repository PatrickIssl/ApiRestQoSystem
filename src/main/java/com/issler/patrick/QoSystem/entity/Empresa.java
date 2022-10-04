package com.issler.patrick.QoSystem.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "razao_social")
	private String razaoSocial;

	@Column(name = "telefone", length = 20)
	private String telefone;

	@Column(name = "cnpj", length = 30)
	private String cnpj;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@JsonIgnore
	@OneToMany(mappedBy = "empresa", cascade=CascadeType.ALL)
	private List<Cargo> cargos;

	@JsonIgnore
	@OneToMany(mappedBy = "empresa" , cascade=CascadeType.ALL)
	private List<Categoria> categorias;

}