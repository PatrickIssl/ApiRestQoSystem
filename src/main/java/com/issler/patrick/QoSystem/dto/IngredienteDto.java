package com.issler.patrick.QoSystem.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Getter @Setter @Constructor
public class IngredienteDto {
	
	private Long id;

	private String nome;
	
	private Double valor;

    private List<ItemDto> items;

	private List<AdicionalDto> adicionais;

}