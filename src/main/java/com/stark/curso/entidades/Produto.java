package com.stark.curso.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="tb_Produto")
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nome;
	private String description;
	private Double preço;
	private String imgUrl;
	
	@ManyToMany
	@JoinTable(name = "tb_produto_categoria", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private Set<Categoria> categoria = new HashSet<>();
	
	@OneToMany(mappedBy =  "id.produto")
	private Set<ItemPedido> items = new HashSet<>();
	
	public Produto () {}

	public Produto(Long id, String nome, String description, Double preço, String imgUrl) {
		super();
		Id = id;
		this.nome = nome;
		this.description = description;
		this.preço = preço;
		this.imgUrl = imgUrl;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPreço() {
		return preço;
	}

	public void setPreço(Double preço) {
		this.preço = preço;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Categoria> getCategoria() {
		return categoria;
	}
	
	public Set<Pedido> getPedido(){
		Set<Pedido> set = new HashSet<>();
		for (ItemPedido x : items) {
			set.add(x.getPedido());
		}
		return set;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(Id, other.Id);
	}

	

	
	
}
