const URL_API = 'http://localhost:8080/api/produtos';

const form = document.getElementById('form-produto');
const tabela = document.getElementById('tabela-produtos');

// 1. Função para carregar e listar produtos (GET)
async function carregarProdutos() {
  const resposta = await fetch(URL_API);
  const produtos = await resposta.json();

  tabela.innerHTML = ''; // Limpa a tabela antes de preencher

  produtos.forEach((produto, index) => {
    const linha = document.createElement('tr');
    linha.innerHTML = `
      <td>${index + 1}</td>
      <td>${produto.nome}</td>
      <td>${produto.quantidade}</td>
      <td>R$ ${produto.preco.toFixed(2)}</td>
      <td>
        <button class="btn-deletar" onclick="deletarProduto(${produto.id})">Excluir</button>
      </td>
    `;
    tabela.appendChild(linha);
  });
}

// 2. Função para cadastrar produto (POST)
form.addEventListener('submit', async (e) => {
  e.preventDefault();

  const novoProduto = {
    nome: document.getElementById('nome').value,
    quantidade: parseInt(document.getElementById('quantidade').value),
    preco: parseFloat(document.getElementById('preco').value)
  };

  await fetch(URL_API, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(novoProduto)
  });

  form.reset();
  carregarProdutos(); // Atualiza a lista na tela
});

// 3. Função para deletar produto (DELETE)
async function deletarProduto(id) {
  await fetch(`${URL_API}/${id}`, {
    method: 'DELETE'
  });
  carregarProdutos(); // Atualiza a lista na tela
}

// Inicializa buscando a lista ao abrir a página
carregarProdutos();