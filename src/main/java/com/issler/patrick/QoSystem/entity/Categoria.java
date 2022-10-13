package com.issler.patrick.QoSystem.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

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

	@Lob
	private byte[] imagem;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	@JsonIgnore
	@OneToMany(mappedBy = "categoria", cascade=CascadeType.PERSIST)
	private List<Item> items;

}