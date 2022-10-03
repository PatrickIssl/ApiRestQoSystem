package com.issler.patrick.QoSystem.dto;


import com.issler.patrick.QoSystem.entity.Ingrediente;
import jdk.nashorn.internal.objects.annotations.Constructor;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import sun.misc.Contended;

@Getter
@Setter
@Constructor
public class AdicionalDto {

	private Long id;

	private int quantidade;

	private IngredienteDto ingrediente;

	private PedidoItemDto pedidoItem;
    
}