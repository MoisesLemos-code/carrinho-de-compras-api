package com.moises.CarrinhoApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moises.CarrinhoApi.domain.Carrinho;


@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Integer>{

	
}
