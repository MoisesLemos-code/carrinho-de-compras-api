package com.moises.CarrinhoApi.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.moises.CarrinhoApi.domain.Usuario;
import com.moises.CarrinhoApi.dto.UsuarioNewDTO;
import com.moises.CarrinhoApi.repositories.UsuarioRepository;
import com.moises.CarrinhoApi.resources.exception.FieldMessage;

public class UsuarioInsertValidator implements ConstraintValidator<UsuarioInsert, UsuarioNewDTO> {

	@Autowired
	private UsuarioRepository repo;

	@Override
	public void initialize(UsuarioInsert ann) {
	}

	@Override
	public boolean isValid(UsuarioNewDTO objDto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();
		// inclua os testes aqui, inserindo erros na lista
		
		Usuario aux = repo.findByNome(objDto.getNome());
		if (aux != null) {
			list.add(new FieldMessage("nome", "Nome de usuário já cadastrado! " + "(Usuario: " + aux.getNome() + ")"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
