package com.moises.CarrinhoApi.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Carrinho implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	private String descricao;
	private double valor;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date data_abertura;
	
	@OneToMany(mappedBy="codigo.carrinho")
	private Set<CarrinhoItem> carrinhoItems = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name="cliente_codigo")
	private Usuario usuario;
	
	public Carrinho() {}

	public Carrinho(Integer codigo, String descricao, double valor, Date data_abertura, Usuario usuario) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
		this.data_abertura = data_abertura;
		this.usuario = usuario;
	}

	public double getValorTotal() {
		double soma = 0.0;
		for(CarrinhoItem ip : carrinhoItems) {
			soma = soma + ip.getSubTotal();
		}
		
		return soma;
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
	
	public Set<CarrinhoItem> getCarrinhoItems() {
		return carrinhoItems;
	}

	public void setCarrinhoItems(Set<CarrinhoItem> carrinhoItems) {
		this.carrinhoItems = carrinhoItems;
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
		Carrinho other = (Carrinho) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
}
