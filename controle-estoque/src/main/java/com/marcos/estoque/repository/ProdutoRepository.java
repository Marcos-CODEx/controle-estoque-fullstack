package com.marcos.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcos.estoque.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	// O Spring Data JPA cria todos os metodos do banco de dados automaticamente!
}
