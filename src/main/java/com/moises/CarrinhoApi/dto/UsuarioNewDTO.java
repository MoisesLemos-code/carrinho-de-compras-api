package com.moises.CarrinhoApi.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.moises.CarrinhoApi.domain.Usuario;
import com.moises.CarrinhoApi.services.validation.UsuarioInsert;

@UsuarioInsert
public class UsuarioNewDTO  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 2, max = 20, message = "O tamanho deve ser entre 2 e 20 caracteres!")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Length(min = 2, max = 120, message = "O tamanho deve ser entre 2 e 120 caracteres!")
	private String nome_completo;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String senha;
	
	public UsuarioNewDTO() {}
	
	public UsuarioNewDTO(Usuario obj) {
		codigo = obj.getCodigo();
		nome   = obj.getNome();
		nome_completo = obj.getNome_completo();
		senha  = obj.getSenha();	
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome_completo() {
		return nome_completo;
	}

	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
