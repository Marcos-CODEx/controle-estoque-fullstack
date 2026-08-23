package com.marcos.estoque.model;

//Importações do JPA (Jakarta Persistence API) que conectam o Java ao Banco de Dados
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//1. @Entity: Avisa ao Spring e ao banco de dados que esta classe representa uma TABELA.
//O banco criará automaticamente uma tabela chamada "produto".
@Entity
public class Produto {
	
// 2. @Id: Indica que o atributo 'id' é a Chave Primária (Primary Key) da tabela.
// 3. @GeneratedValue: Define que o banco gera o ID automaticamente (auto-incremento).
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

//Atributos normais viram colunas na tabela "produto"
private String nome;  		// Coluna para armazenar o nome (TEXT/VARCHAR)
private Integer quantidade;	// Coluna para a quantidade em estoque (INTEGER)
private Double preco;		// Coluna para o preço unitário (DECIMAL/DOUBLE)


// 4. Construtor Vazio: OBRIGATÓRIO do JPA.
// O banco de dados precisa dele para instanciar os objetos automaticamente ao ler dados.
public Produto() {}

//5. Construtor Completo: Facilita a criação manual de novos produtos no código Java.
public Produto(String nome, Integer quantidade, Double preco) {
	this.nome = nome;
	this.quantidade = quantidade;
	this.preco = preco;
}

//6. Getters e Setters: Permitem o acesso seguro (encapsulamento) aos dados privados da classe.

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public Integer getQuantidade() {
	return quantidade;
}

public void setQuantidade(Integer quantidade) {
	this.quantidade = quantidade;
}

public Double getPreco() {
	return preco;
}

public void setPreco(Double preco) {
	this.preco = preco;
}




}
