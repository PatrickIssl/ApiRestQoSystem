package com.issler.patrick.QoSystem.dto;

import com.issler.patrick.QoSystem.entity.Empresa;
import com.issler.patrick.QoSystem.entity.Item;
import jdk.nashorn.internal.objects.annotations.Constructor;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.List;

@Getter
@Setter
@Constructor
public class CategoriaDto {

	private Long id;

	private String nome;

	private String imageUrl;

	private MultipartFile imagem;

	private EmpresaDto empresa;

	private List<ItemDto> items;

}