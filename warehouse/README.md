# Projeto Warehouse: Gestão de Produtos

## 1. Visão Geral

Este projeto é uma aplicação web completa para gerenciamento de um armazém de produtos, desenvolvida utilizando o ecossistema Spring Boot. A aplicação oferece tanto uma interface web para usuários quanto uma API REST para integrações.

---

## 2. Funcionalidades Principais

-   **Interface Web (UI)**: Uma página web simples e funcional para visualizar, criar, editar e deletar produtos em tempo real.
-   **API RESTful**: Endpoints que seguem os padrões REST para todas as operações CRUD (Create, Read, Update, Delete) de produtos.
-   **Documentação de API Interativa**: Interface Swagger UI para visualizar e testar todos os endpoints da API diretamente pelo navegador.
-   **Persistência de Dados**: Utiliza um banco de dados H2 configurado em modo arquivo, garantindo que os dados não sejam perdidos ao reiniciar a aplicação.

---

## 3. Tecnologias Utilizadas

-   **Backend**: Java 17, Spring Boot 3.3.0
-   **Acesso a Dados**: Spring Data JPA, Hibernate
-   **Banco de Dados**: H2 Database Engine (modo arquivo)
-   **Interface Web**: Spring Web, Thymeleaf
-   **API**: Spring Web, Springdoc OpenAPI (Swagger)
-   **Build e Dependências**: Gradle
-   **Utilitários**: Lombok

---

## 4. Como Configurar e Executar o Projeto

Siga os passos abaixo para executar a aplicação em seu ambiente local.

### Pré-requisitos

-   **Java Development Kit (JDK) 17** ou superior.
-   **Gradle** (opcional, pois o projeto usa o Gradle Wrapper).

### Passo a Passo para Execução

1.  **Abra um Terminal**:
    Navegue até a pasta raiz do projeto (`c:\Users\zefpe\OneDrive\Área de Trabalho\warehouse`).

2.  **Execute o Comando de Build e Run**:
    Use o Gradle Wrapper, que já vem incluído no projeto. Ele irá baixar as dependências e iniciar o servidor.

    -   No Windows (usando Command Prompt ou PowerShell):
        ```bash
        .\gradlew.bat bootRun
        ```
    -   No Linux ou macOS:
        ```bash
        ./gradlew bootRun
        ```

3.  **Acesse a Aplicação**:
    Após a inicialização, a aplicação estará disponível no seu navegador. O servidor roda na porta **8082**.

    O **microserviço `warehouse`** em execução. O `storefront` depende dele para funcionar.

---

## 5. Guia de Utilização

Depois de iniciar a aplicação, você pode interagir com ela de 3 formas principais:

### 5.1. Interface Web (Storefront)

Esta é a interface principal para o usuário final.

-   **URL de Acesso**: [http://localhost:8082/storefront](http://localhost:8082/storefront)
-   **Funcionalidades**:
    -   **Visualizar Produtos**: A tabela principal exibe todos os produtos cadastrados.
    -   **Adicionar Produto**: Preencha o formulário no topo da página e clique em "Submit".
    -   **Editar Produto**: Clique no link "Edit" na linha do produto desejado.
    -   **Deletar Produto**: Clique no link "Delete" para remover um produto.

### 5.2. API REST com Documentação Swagger

Para desenvolvedores e integrações, a API REST é a forma recomendada de interação.

-   **URL da Documentação**:
    [http://localhost:8082/swagger-ui.html](http://localhost:8082/swagger-ui.html)
-   **Funcionalidades**: A interface Swagger permite visualizar todos os endpoints, seus parâmetros, e testá-los diretamente.
-   **Endpoints Principais**:
    -   `GET /api/produtos`
    -   `POST /api/produtos`
    -   `GET /api/produtos/{id}`
    -   `PUT /api/produtos/{id}`
    -   `DELETE /api/produtos/{id}`

### 5.3. Acesso Direto ao Banco de Dados (H2 Console)

### Para depuração, é possível inspecionar o banco de dados diretamente.

1.  **URL do Console**: [http://localhost:8082/h2-console-storefront](http://localhost:8082/h2-console-storefront)
2.  **Credenciais de Acesso**:
    -   **JDBC URL**: `jdbc:h2:file:./warehouse`
    -   **User Name**: `sa`
    -   **Password**: `guest`
3.  **Clique em "Connect"**.
    -   **Exemplo de Consulta**: Para ver todos os produtos, execute o comando `SELECT * FROM PRODUTO;`.

---

## 6. Estrutura de Diretórios

```
warehouse/
|-- .gradle/         # Arquivos de cache do Gradle
|-- gradle/          # Gradle Wrapper
|-- src/
|   |-- main/
|   |   |-- java/br/com/warehouse/  # Código-fonte Java
|   |   |   |-- controller/       # Controladores (API e Web)
|   |   |   |-- entity/           # Entidades do banco de dados
|   |   |   |-- repository/       # Repositórios de dados
|   |   |   `-- WarehouseApplication.java # Ponto de entrada
|   |   `-- resources/
|   |       |-- static/           # CSS, JavaScript, Imagens
|   |       |-- templates/        # Arquivos HTML (Thymeleaf)
|   |       `-- application.properties # Configurações do Spring
|-- build.gradle.kts # Script de build

```
