package com.issler.patrick.QoSystem.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

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

	@Lob
	@Nullable
	private String imagem;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@JsonIgnore
	@OneToMany(mappedBy = "item", cascade = CascadeType.PERSIST)
	private List<PedidoItem> pedidoItems;

	@ManyToMany(mappedBy = "items", cascade = CascadeType.PERSIST)
	private List<Ingrediente> ingredientes;

}