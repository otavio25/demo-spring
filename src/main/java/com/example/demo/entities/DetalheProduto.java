package com.example.demo.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_detalhe_produto")
public class DetalheProduto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	
	@OneToOne
	@MapsId
	private Produto produto;
	
	public DetalheProduto() {	
	}
	
	public DetalheProduto(Long id_detalhe_produto, String descricao, Produto produto) {
		super();
		this.id = id_detalhe_produto;
		this.descricao = descricao;
		this.produto = produto;
	}

	public Long getId_detalhe_produto() {
		return id;
	}

	public void setId_detalhe_produto(Long id_detalhe_produto) {
		this.id = id_detalhe_produto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		DetalheProduto other = (DetalheProduto) obj;
		return Objects.equals(id, other.id);
	}
}
