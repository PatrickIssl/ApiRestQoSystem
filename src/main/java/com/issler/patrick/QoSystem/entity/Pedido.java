package com.issler.patrick.QoSystem.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;



@Entity
@Component
public class Pedido {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "status")
	private String status;
	
	@Column(name = "observacao")
	private String observacao;
	
	@Column(name = "retirar")
	private String retirar;
	
	@Column(name = "dividir")
	private String dividir;
	
	@Column(name = "enderecoEntrega")
	private String enderecoEntrega;
	
	@ManyToOne
	private Pessoa pessoa;

	@OneToMany(mappedBy = "pedidoItem")
	private List<PedidoItem> pedidoItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getRetirar() {
		return retirar;
	}

	public void setRetirar(String retirar) {
		this.retirar = retirar;
	}

	public String getDividir() {
		return dividir;
	}

	public void setDividir(String dividir) {
		this.dividir = dividir;
	}

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<PedidoItem> getPedidoItem() {
		return pedidoItem;
	}

	public void setPedidoItem(List<PedidoItem> pedidoItem) {
		this.pedidoItem = pedidoItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dividir == null) ? 0 : dividir.hashCode());
		result = prime * result + ((enderecoEntrega == null) ? 0 : enderecoEntrega.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((pedidoItem == null) ? 0 : pedidoItem.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((retirar == null) ? 0 : retirar.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Pedido other = (Pedido) obj;
		if (dividir == null) {
			if (other.dividir != null)
				return false;
		} else if (!dividir.equals(other.dividir))
			return false;
		if (enderecoEntrega == null) {
			if (other.enderecoEntrega != null)
				return false;
		} else if (!enderecoEntrega.equals(other.enderecoEntrega))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (pedidoItem == null) {
			if (other.pedidoItem != null)
				return false;
		} else if (!pedidoItem.equals(other.pedidoItem))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (retirar == null) {
			if (other.retirar != null)
				return false;
		} else if (!retirar.equals(other.retirar))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	
	
}