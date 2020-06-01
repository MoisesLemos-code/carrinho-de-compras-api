package com.moises.CarrinhoApi.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.moises.CarrinhoApi.domain.Carrinho;
import com.moises.CarrinhoApi.domain.CarrinhoItem;
import com.moises.CarrinhoApi.domain.Usuario;
import com.moises.CarrinhoApi.repositories.CarrinhoItemRepository;
import com.moises.CarrinhoApi.repositories.CarrinhoRepository;
import com.moises.CarrinhoApi.repositories.UsuarioRepository;


@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder  pe;
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	@Autowired
	private CarrinhoItemRepository carrinhoItemRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		
		Usuario user1 = new Usuario(null, "MASTER", "Usuário master", pe.encode("2143"));
		Usuario user2 = new Usuario(null, "TESTE", "Usuário de teste", pe.encode("1234"));
		
		usuarioRepository.saveAll(Arrays.asList(user1, user2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Carrinho c1 = new Carrinho(null, "Compras 01", 550, sdf.parse("24/05/2020 09:00"), user1 );
		Carrinho c2 = new Carrinho(null, "Compras 02", 350, sdf.parse("25/05/2020 10:00"), user2 );
		Carrinho c3 = new Carrinho(null, "Compras 03", 150, sdf.parse("26/05/2020 11:32"), user1 );
		Carrinho c4 = new Carrinho(null, "Compras 04", 50, sdf.parse("27/05/2020 13:32"), user1 );
		Carrinho c5 = new Carrinho(null, "Compras 05", 150, sdf.parse("27/05/2020 11:32"), user2 );
		
		CarrinhoItem ci1 = new CarrinhoItem(null, "Camiseta Listrada", 70, 1, c1);
		CarrinhoItem ci2 = new CarrinhoItem(null, "Camisa", 120, 1, c1);
		CarrinhoItem ci3 = new CarrinhoItem(null, "Calça jeans", 100, 2, c1);
		CarrinhoItem ci4 = new CarrinhoItem(null, "All-Star converse", 250, 1, c1);
		
		CarrinhoItem ci5 = new CarrinhoItem(null, "Picanha 20kg", 50, 1, c2);
		CarrinhoItem ci6 = new CarrinhoItem(null, "Linguiça Suina 10kg", 13, 2, c2);
		CarrinhoItem ci7 = new CarrinhoItem(null, "Cerveja 2L", 12, 2, c2);
		
		CarrinhoItem ci8 = new CarrinhoItem(null, "Moleton azul listrado", 230, 1, c3);
		CarrinhoItem ci9 = new CarrinhoItem(null, "Saia rodada", 50, 2, c3);
		
		CarrinhoItem ci10 = new CarrinhoItem(null, "Blusa inverno dourado", 30, 2, c4);
		CarrinhoItem ci11 = new CarrinhoItem(null, "Bermuda marinheiro", 50, 1, c4);
		
		CarrinhoItem ci12 = new CarrinhoItem(null, "Milho verde 250g", 4, 2, c5);
		CarrinhoItem ci13 = new CarrinhoItem(null, "Coca cola 2L", 7, 2, c5);
		CarrinhoItem ci14 = new CarrinhoItem(null, "Azeitona 150g", 2.50, 2, c5);
		CarrinhoItem ci15 = new CarrinhoItem(null, "Arroz tião verde 10kg", 13, 1, c5);
		CarrinhoItem ci16 = new CarrinhoItem(null, "Feijão dourado 5kg", 8, 1, c5);
		CarrinhoItem ci17 = new CarrinhoItem(null, "Bala Fini 100g", 5, 2, c5);
		
		carrinhoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
		carrinhoItemRepository.saveAll(Arrays.asList(ci1,ci2, ci3, ci4, ci5,
				ci6, ci7, ci8, ci9, ci10, ci11, ci12, ci13, ci14, ci15, ci16, ci17));
	}

}
