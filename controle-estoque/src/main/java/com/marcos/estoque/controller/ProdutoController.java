package com.marcos.estoque.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.estoque.model.Produto;
import com.marcos.estoque.repository.ProdutoRepository;

// 1. @RestController: Indica ao Spring que esta classe é um controlador REST.
// Ela vai receber requisições HTTP e devolver as respostas diretamente em formato JSON.
@RestController

// 2. @RequestMapping: Define o endereço base (rota) para acessar esta API.
// Qualquer chamada para http://localhost:8080/api/produtos será direcionada para cá.
@RequestMapping("/api/produtos")

// 3. @CrossOrigin: Libera as requisições de outras origens (como uma página HTML rodando localmente).
// Evita o bloqueio de segurança do navegador conhecido como CORS.
@CrossOrigin(origins = "*")
public class ProdutoController {

    // 4. @Autowired: Injeção de Dependência automática.
    // O Spring gerencia e nos entrega uma instância pronta do ProdutoRepository para usarmos aqui.
    private final ProdutoRepository produtoRepository;

    ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // 5. @GetMapping: Mapeia requisições HTTP do tipo GET na rota /api/produtos.
    // Usado para BUSCAR/LISTAR informações do banco de dados.
    @GetMapping
    public List<Produto> listar() {
        // O método findAll() busca todos os registros da tabela "produto" no banco de dados.
        return produtoRepository.findAll();
    }

    // 6. @PostMapping: Mapeia requisições HTTP do tipo POST na rota /api/produtos.
    // Usado para CRIAR/SALVAR novas informações no banco de dados.
    // 7. @RequestBody: Converte os dados JSON recebidos no corpo da requisição em um objeto Java do tipo Produto.
    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        // O método save() insere o novo produto no banco de dados e o retorna com o ID gerado.
        return produtoRepository.save(produto);
    }
    
 // Mapeia requisições HTTP DELETE para /api/produtos/{id}
    // O @PathVariable indica que o valor da URL ({id}) será passado para a variável Long id
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
    
 // Mapeia requisições HTTP PUT para /api/produtos/{id}
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        // Define o ID recebido no objeto para garantir a alteração do registro correto
        produtoAtualizado.setId(id);
        
        // O método save() do JPA atualiza o registro se o ID já existir no banco
        return produtoRepository.save(produtoAtualizado);
    }
    
    
    
    
    
    
}