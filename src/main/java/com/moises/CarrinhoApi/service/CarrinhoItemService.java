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

import com.moises.CarrinhoApi.domain.CarrinhoItem;
import com.moises.CarrinhoApi.repositories.CarrinhoItemRepository;

@Service
public class CarrinhoItemService {

	@Autowired
	private CarrinhoItemRepository repo;

	public CarrinhoItem find(Integer id) {
		Optional<CarrinhoItem> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + CarrinhoItem.class.getSimpleName(), null));
	}
	
	public CarrinhoItem insert(CarrinhoItem obj) {
		obj.setCodigo(null);
		return repo.save(obj);
	}
	
	public CarrinhoItem update(CarrinhoItem obj) {
		CarrinhoItem newObj = find(obj.getCodigo());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não foi possível excluir o item, pois o mesmo possui vinculos!");
		}
	}
	
	public List<CarrinhoItem> findAll(){
		return repo.findAll();
	}
	
	public Page<CarrinhoItem> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return repo.findAll(pageRequest);
	}
	
	private void updateData(CarrinhoItem newObj, CarrinhoItem obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setValor(obj.getValor());
		newObj.setQuantidade(obj.getQuantidade());
	}
}
