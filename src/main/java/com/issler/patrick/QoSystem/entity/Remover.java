package com.issler.patrick.QoSystem.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Table(name = "remover")
@Entity
@Component
@Getter @Setter @NoArgsConstructor
public class Remover {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    @ManyToOne(cascade=CascadeType.PERSIST )
	@JoinColumn(name = "ingrediente_id")
	private Ingrediente ingrediente;

	@JsonIgnore
	@ManyToOne(cascade=CascadeType.PERSIST )
	@JoinColumn(name = "pedidoitem_id")
	private PedidoItem pedidoItem;
    
}