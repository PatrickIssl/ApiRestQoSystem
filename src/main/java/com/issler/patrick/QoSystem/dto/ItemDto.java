package com.issler.patrick.QoSystem.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Constructor
public class ItemDto {

	private Long id;

	private String nome;

	private double valor;

	private String imageUrl;

	private MultipartFile imagem;

	private CategoriaDto categoria;

	private List<PedidoItemDto> pedidoItems;

	private List<IngredienteDto> ingredientes;

}