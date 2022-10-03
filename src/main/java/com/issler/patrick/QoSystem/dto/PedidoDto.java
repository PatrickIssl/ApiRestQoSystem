package com.issler.patrick.QoSystem.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;


@Getter @Setter @NoArgsConstructor
public class PedidoDto {
	
	private Long id;

	private int status;

	private String observacao;

	private String retirar;

	private int dividir;

	private String enderecoEntrega;

	private PessoaDto pessoa;

	private List<PedidoItemDto> pedidoItems;

}