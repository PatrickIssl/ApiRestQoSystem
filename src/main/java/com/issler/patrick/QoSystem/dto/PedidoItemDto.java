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
public class PedidoItemDto {
	
	private Long id;

	private int quantidade;

	private PedidoDto pedido;

	private ItemDto item;

	private List<AdicionalDto> adicionais;
}