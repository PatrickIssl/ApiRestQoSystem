package com.issler.patrick.QoSystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.issler.patrick.QoSystem.entity.Empresa;
import com.issler.patrick.QoSystem.entity.Pessoa;
import jdk.nashorn.internal.objects.annotations.Constructor;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Constructor
public class EnderecoDto {

	private Long id;

	private String rua;

	private String bairro;

	private String numero;

	private String uf;

	private String pais;

	private String observacao;

	private Pessoa pessoa;

	private EmpresaDto empresa;

}