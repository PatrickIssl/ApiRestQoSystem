package com.issler.patrick.QoSystem.dto;

import com.issler.patrick.QoSystem.entity.Empresa;
import com.issler.patrick.QoSystem.entity.Pessoa;
import jdk.nashorn.internal.objects.annotations.Constructor;
import java.util.List;

@Getter
@Setter
@Constructor
public class CargoDto {

	private Long id;

	private String nome;

	private Empresa empresa;

	private List<PessoaDto> pessoas;

}