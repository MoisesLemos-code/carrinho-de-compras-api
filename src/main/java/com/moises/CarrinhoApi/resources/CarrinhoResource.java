package com.moises.CarrinhoApi.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.moises.CarrinhoApi.domain.Carrinho;
import com.moises.CarrinhoApi.dto.CarrinhoDTO;
import com.moises.CarrinhoApi.service.CarrinhoService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/carrinho")
public class CarrinhoResource {

	@Autowired
	private CarrinhoService service;

	@RequestMapping(value="/find/{id}", method = RequestMethod.GET)
	public ResponseEntity<Carrinho> find(@PathVariable Integer id) {
		Carrinho obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CarrinhoDTO objDto) {
		Carrinho obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		// Fornecer URI após inserir!
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getCodigo())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CarrinhoDTO objDto, @PathVariable Integer id) {
		Carrinho obj = service.fromDTO(objDto);
		obj.setCodigo(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Carrinho> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/all",method = RequestMethod.GET)
	public ResponseEntity<List<CarrinhoDTO>> findAll() {
		List<Carrinho> list = service.findAll();
		List<CarrinhoDTO> listDto = list.stream().map(obj -> new CarrinhoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<CarrinhoDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "codigo") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Carrinho> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<CarrinhoDTO> listDto = list.map(obj -> new CarrinhoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

}
