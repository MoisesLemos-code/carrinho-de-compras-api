package com.moises.CarrinhoApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moises.CarrinhoApi.domain.CarrinhoItem;


@Repository
public interface CarrinhoItemRepository extends JpaRepository<CarrinhoItem, Integer>{

	
}
