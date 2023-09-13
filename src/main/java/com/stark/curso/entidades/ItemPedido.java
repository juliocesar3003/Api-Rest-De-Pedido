package com.stark.curso.entidades;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stark.curso.entidades.pk.ItemPedidoPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId	
	private ItemPedidoPk id = new ItemPedidoPk();
	private Integer quantidade;
	private Double preço;
	
	public ItemPedido() {
		
	}
	
	public ItemPedido(Pedido pedido,Produto produto, Integer quantidade, Double preço) {
		super();
		this.quantidade = quantidade;
		this.preço = preço;
		id.setProduto(produto);
		id.setPedido(pedido);
	}
	@JsonIgnore
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto() {
		id.setProduto(getProduto());
	}
	
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido() {
		id.setPedido(getPedido());
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreço() {
		return preço;
	}

	
	public void setPreço(Double preço) {
		this.preço = preço;
	}
	
	public Double getSubTotal() {
	 Double valor = preço * quantidade;
	 
	 return valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
