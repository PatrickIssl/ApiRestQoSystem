package com.issler.patrick.QoSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Table(name = "mesa")
@Entity
@Component
@Getter
@Setter
@NoArgsConstructor
public class Mesa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome")
	private String nome;


	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;


}