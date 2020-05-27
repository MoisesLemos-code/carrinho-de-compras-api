package com.moises.CarrinhoApi.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.moises.CarrinhoApi.domain.Carrinho;
import com.moises.CarrinhoApi.dto.CarrinhoDTO;
import com.moises.CarrinhoApi.repositories.CarrinhoRepository;


@Service
public class CarrinhoService {
	
	@Autowired
	private CarrinhoRepository repo;
	
	public Carrinho find(Integer id) {
		Optional<Carrinho> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Carrinho.class.getSimpleName(), null));
	}
	
	public Carrinho insert(Carrinho obj) {
		obj.setCodigo(null);
		return repo.save(obj);
	}
	
	public Carrinho update(Carrinho obj) {
		Carrinho newObj = find(obj.getCodigo());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir este carrinho de compras!");
		}
	}
	
	public List<Carrinho> findAll(){
		return repo.findAll();
	}
	
	public Page<Carrinho> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return repo.findAll(pageRequest);
	}
	
	public Carrinho fromDTO(CarrinhoDTO objDto) {
		return new Carrinho(objDto.getCodigo(), objDto.getDescricao(),  objDto.getValor(), objDto.getData_abertura(), objDto.getUsuario());
	}
	
	private void updateData(Carrinho newObj, Carrinho obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setValor(obj.getValor());
	}

}
