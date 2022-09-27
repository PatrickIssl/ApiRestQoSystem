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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "conta")
@Entity
@Component
@Getter
@Setter
@NoArgsConstructor
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "conta")
	private String conta;

	@Column(name = "senha")
	private String senha;

	@Nullable
	@Transient
	private String mfa;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

}