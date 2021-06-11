package com.issler.patrick.QoSystem.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;



@Entity
@Component
public class Ingrediente {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "nome")
	private String nome;
	
	@NotNull
	@Column(name = "valor")
	private double valor;
	
	@OneToMany(mappedBy = "ingrediente")
	private List<Adicional> adicional;
	
	@OneToMany(mappedBy = "ingrediente")
	private List<ItemIngrediente> itemIngrediente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Adicional> getAdicional() {
		return adicional;
	}

	public void setAdicional(List<Adicional> adicional) {
		this.adicional = adicional;
	}

	public List<ItemIngrediente> getItemIngrediente() {
		return itemIngrediente;
	}

	public void setItemIngrediente(List<ItemIngrediente> itemIngrediente) {
		this.itemIngrediente = itemIngrediente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adicional == null) ? 0 : adicional.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itemIngrediente == null) ? 0 : itemIngrediente.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		if (adicional == null) {
			if (other.adicional != null)
				return false;
		} else if (!adicional.equals(other.adicional))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemIngrediente == null) {
			if (other.itemIngrediente != null)
				return false;
		} else if (!itemIngrediente.equals(other.itemIngrediente))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}
	
	
	
	
	
}