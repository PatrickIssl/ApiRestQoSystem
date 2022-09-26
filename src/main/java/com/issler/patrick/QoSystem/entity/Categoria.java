package com.issler.patrick.QoSystem.entity;

import javax.persistence.*;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "categoria")
@Entity
@Component
@Getter
@Setter
@NoArgsConstructor
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Nullable
	@Lob
	@Column(name = "imagem")
	private byte[] imagem;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;


	@OneToMany(mappedBy = "categoria", cascade=CascadeType.ALL)
	private List<Item> items;

}