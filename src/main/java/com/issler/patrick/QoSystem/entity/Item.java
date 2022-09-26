package com.issler.patrick.QoSystem.entity;

import javax.persistence.*;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "item")
@Entity
@Component
@Getter
@Setter
@NoArgsConstructor
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "valor")
	private double valor;

	@Nullable
	@Lob
	@Column(name = "imagem")
	private byte[] imagem;

	@ManyToOne()
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;


	@OneToMany(mappedBy = "item")
	private List<PedidoItem> pedidoItems;

}