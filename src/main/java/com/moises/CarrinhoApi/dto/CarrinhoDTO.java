package com.moises.CarrinhoApi.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.moises.CarrinhoApi.domain.Carrinho;
import com.moises.CarrinhoApi.domain.Usuario;

public class CarrinhoDTO  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 2, max = 20, message = "O tamanho deve ser entre 2 e 20 caracteres!")
	private String descricao;
	private double valor;
	
	
	private Usuario usuario;
	
	public CarrinhoDTO() {}
	
	public CarrinhoDTO(Carrinho obj) {
		codigo = obj.getCodigo();
		descricao = obj.getDescricao();
		valor = obj.getValor();
		usuario = obj.getUsuario();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
