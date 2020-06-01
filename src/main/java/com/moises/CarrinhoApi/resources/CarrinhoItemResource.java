package com.moises.CarrinhoApi.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.moises.CarrinhoApi.domain.CarrinhoItem;
import com.moises.CarrinhoApi.dto.CarrinhoItemDTO;
import com.moises.CarrinhoApi.services.CarrinhoItemService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/carrinhoItem")
public class CarrinhoItemResource {

	@Autowired
	private CarrinhoItemService service;

	@RequestMapping(value="/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<CarrinhoItem> find(@PathVariable Integer id) {
		CarrinhoItem obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CarrinhoItemDTO objDto) {
		CarrinhoItem obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		// Fornecer URI após inserir!
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodigo())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CarrinhoItemDTO objDto, @PathVariable Integer id) {
		CarrinhoItem obj = service.fromDTO(objDto);
		obj.setCodigo(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<CarrinhoItem> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public ResponseEntity<List<CarrinhoItem>> findAll() {
		List<CarrinhoItem> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<CarrinhoItem>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "codigo") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<CarrinhoItem> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}

}
