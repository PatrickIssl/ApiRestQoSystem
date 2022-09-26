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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Nullable
	@Lob
	@Column(name = "imagem")
	private byte[] imagem;

	@ManyToOne()
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;


	@OneToMany(mappedBy = "categoria")
	private List<Item> items;

}