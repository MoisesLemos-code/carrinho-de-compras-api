package com.moises.CarrinhoApi.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class CarrinhoItem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private CarrinhoItemPK codigo = new CarrinhoItemPK();
	
	private String titulo;
	private double valor;
	private Integer quantidade;
	
	public CarrinhoItem() {}

	public CarrinhoItem(Carrinho carrinho, CarrinhoItem carrinhoItem, String titulo, double valor, Integer quantidade) {
		super();
		codigo.setCarrinho(carrinho);
		codigo.setCarrinhoItem(carrinhoItem);
		this.titulo = titulo;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public double getSubTotal() {
		return valor * quantidade;
	}
	
	public CarrinhoItemPK getCodigo() {
		return codigo;
	}

	public void setCodigo(CarrinhoItemPK codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		CarrinhoItem other = (CarrinhoItem) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
}
