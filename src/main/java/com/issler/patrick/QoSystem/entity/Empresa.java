package com.issler.patrick.QoSystem.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "empresa")
@Entity
@Component
@Getter @Setter @NoArgsConstructor
public class Empresa {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(name = "razao_social", length = 255)
	private String razaoSocial;
	
	@NotNull
	@Column(name = "telefone", length = 20)
	private String telefone;
	
	@NotNull
	@Column(name = "cnpj", length = 30)
	private String cnpj;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;
	
}