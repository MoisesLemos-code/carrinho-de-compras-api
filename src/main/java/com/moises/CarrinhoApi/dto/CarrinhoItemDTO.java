package com.moises.CarrinhoApi.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.moises.CarrinhoApi.domain.CarrinhoItem;

public class CarrinhoItemDTO  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 2, max = 40, message = "O tamanho deve ser entre 2 e 40 caracteres!")
	private String titulo;
	private double valor;
	private Integer quantidade;
	
	private Integer codigo_carrinho;
	
	public CarrinhoItemDTO() {}
	
	public CarrinhoItemDTO(CarrinhoItem obj) {
		codigo = obj.getCodigo();
		titulo = obj.getTitulo();
		valor  = obj.getValor();
		quantidade = obj.getQuantidade();
		codigo_carrinho = obj.getCarrinho().getCodigo();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
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

	public Integer getCodigo_carrinho() {
		return codigo_carrinho;
	}

	public void setCodigo_carrinho(Integer codigo_carrinho) {
		this.codigo_carrinho = codigo_carrinho;
	}
	
}
