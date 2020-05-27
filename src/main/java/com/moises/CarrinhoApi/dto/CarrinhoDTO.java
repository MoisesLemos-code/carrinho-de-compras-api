package com.moises.CarrinhoApi.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date data_abertura;
	
	private Usuario usuario;
	
	public CarrinhoDTO() {}
	
	public CarrinhoDTO(Carrinho obj) {
		codigo = obj.getCodigo();
		descricao = obj.getDescricao();
		valor = obj.getValor();
		data_abertura = obj.getData_abertura();
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

	public Date getData_abertura() {
		return data_abertura;
	}

	public void setData_abertura(Date data_abertura) {
		this.data_abertura = data_abertura;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
