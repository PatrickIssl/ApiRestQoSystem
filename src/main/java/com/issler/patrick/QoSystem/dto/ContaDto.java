package com.issler.patrick.QoSystem.dto;

import jdk.nashorn.internal.objects.annotations.Constructor;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@Constructor
public class ContaDto {

	private Long id;

	private String conta;

	private String senha;

	private String mfa;

	private PessoaDto pessoa;

}