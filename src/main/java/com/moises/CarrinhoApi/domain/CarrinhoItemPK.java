package com.moises.CarrinhoApi.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class CarrinhoItemPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="carrinho_codigo")
	private Carrinho carrinho;
	
	@ManyToOne
	@JoinColumn(name="carrinhoItem_codigo")
	private CarrinhoItem carrinhoItem;

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public CarrinhoItem getCarrinhoItem() {
		return carrinhoItem;
	}

	public void setCarrinhoItem(CarrinhoItem carrinhoItem) {
		this.carrinhoItem = carrinhoItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carrinho == null) ? 0 : carrinho.hashCode());
		result = prime * result + ((carrinhoItem == null) ? 0 : carrinhoItem.hashCode());
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
		CarrinhoItemPK other = (CarrinhoItemPK) obj;
		if (carrinho == null) {
			if (other.carrinho != null)
				return false;
		} else if (!carrinho.equals(other.carrinho))
			return false;
		if (carrinhoItem == null) {
			if (other.carrinhoItem != null)
				return false;
		} else if (!carrinhoItem.equals(other.carrinhoItem))
			return false;
		return true;
	}
	
	
}
