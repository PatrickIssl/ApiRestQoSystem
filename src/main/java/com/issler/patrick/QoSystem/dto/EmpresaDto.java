package com.issler.patrick.QoSystem.dto;


import com.issler.patrick.QoSystem.entity.Cargo;
import com.issler.patrick.QoSystem.entity.Categoria;
import jdk.nashorn.internal.objects.annotations.Constructor;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.List;

@Getter
@Setter
@Constructor
public class EmpresaDto {

	private Long id;

	private String razaoSocial;

	private String telefone;

	private String cnpj;

	private EnderecoDto endereco;

	private List<Cargo> cargos;

	private List<CategoriaDto> categorias;

}