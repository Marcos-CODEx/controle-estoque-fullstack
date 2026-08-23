# 📦 Controle de Estoque (Full Stack)

Sistema completo para gerenciamento de controle de estoque desenvolvido com API REST no back-end e interface web interativa no front-end.

🔧 Tecnologias Utilizadas

### Back-end
➤ Java 
➤ Spring Boot (Web, Data JPA)
➤ Maven

### Front-end
➤ HTML5
➤ CSS3
➤ JavaScript (ES6+)

---

⚙️ Como Executar o Projeto

1. **Pré-requisitos**
   * Java JDK 17+ instalado
   * Navegador Web atualizado

🛠️ Funcionalidades
- [x] Cadastro de produtos
- [x] Listagem e consulta de estoque
- [x] Atualização e remoção de itens

### Acesso ao Banco de Dados (H2 Console)**
Com a API rodando, você pode acessar o painel do banco em memória pelo navegador:
* **URL:** `http://localhost:8080/h2-console`
* **JDBC URL:** `jdbc:h2:mem:testdb` *(ou a URL definida no seu application.properties)*
* **User:** `sa`
* **Password:** *(deixe em branco)*
## 📁 Estrutura do Repositório

```text
controle-estoque-fullstack/
├── controle-estoque/    # API REST em Spring Boot
└── estoque-frontend/    # Interface Web em HTML, CSS e JS
