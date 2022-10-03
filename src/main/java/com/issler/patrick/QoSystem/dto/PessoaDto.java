package com.issler.patrick.QoSystem.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter @Setter @NoArgsConstructor
public class PessoaDto {
	
	private Long id;

	private String nome;
	
	private String cpf;
	
	private Date dataNascimento;

	private Double salario;

	private String genero;
	
	private String telefone;

	private ContaDto conta;

	private CargoDto cargo;
    
	private EnderecoDto endereco;

	private List<PedidoDto> pedidos;

}