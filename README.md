# Projeto de Microsserviços: Storefront e Warehouse

Este projeto consiste em dois microsserviços que trabalham em conjunto para formar uma aplicação de vitrine de produtos.

## Visão Geral

-   **Warehouse**: Microsserviço responsável pelo gerenciamento e persistência dos dados de produtos. Ele expõe uma API REST para operações de CRUD (Criar, Ler, Atualizar, Deletar).
-   **Storefront**: Microsserviço que consome a API do `warehouse` para exibir os produtos em uma interface web amigável.

---

## 1. Microsserviço: Warehouse

O `warehouse` é o coração do sistema, atuando como o único ponto de verdade para os dados de produtos.

### Funcionalidades

-   **API RESTful**: Endpoints para criar, ler, atualizar e deletar produtos.
-   **Persistência de Dados**: Utiliza um banco de dados H2 em modo arquivo para garantir que os dados não sejam perdidos.
-   **Documentação Interativa**: Interface Swagger UI para testar e visualizar os endpoints da API.

### Como Executar

1.  **Navegue até a pasta do `warehouse`**:
    ```bash
    cd warehouse
    ```

2.  **Execute a aplicação com o Gradle**:
    -   No Windows:
        ```bash
        gradlew.bat bootRun
        ```
    -   No Linux/macOS:
        ```bash
        ./gradlew bootRun
        ```

3.  **Acesse os recursos**:
    -   **API (Swagger)**: [http://localhost:8082/swagger-ui.html](http://localhost:8082/swagger-ui.html)
    -   **Console do Banco de Dados**: [http://localhost:8082/h2-console-storefront](http://localhost:8082/h2-console-storefront)
        -   **JDBC URL**: `jdbc:h2:file:./warehouse`
        -   **User**: `sa`
        -   **Password**: `guest`

---

## 2. Microsserviço: Storefront

O `storefront` é a camada de apresentação, responsável por exibir os produtos para o usuário final.

### Funcionalidades

-   **Visualização de Produtos**: Exibe uma lista de produtos obtida do `warehouse`.
-   **Interface Web**: Páginas para listar, adicionar, editar e deletar produtos.

### Como Executar

1.  **Certifique-se de que o `warehouse` está em execução.**

2.  **Navegue até a pasta do `storefront`**:
    ```bash
    cd storefront
    ```

3.  **Execute a aplicação com o Gradle**:
    -   No Windows:
        ```bash
        gradlew.bat bootRun
        ```
    -   No Linux/macOS:
        ```bash
        ./gradlew bootRun
        ```

4.  **Acesse a vitrine**:
    -   **Página Principal**: [http://localhost:8081/storefront](http://localhost:8081/storefront)

---

## Interação entre os Microsserviços

1.  O `storefront` é configurado para se comunicar com o `warehouse` através da URL `http://localhost:8082/api/produtos`.
2.  Quando um usuário acessa a página do `storefront`, ele envia uma requisição para o `warehouse` para obter a lista de produtos.
3.  O `warehouse` responde com os dados, e o `storefront` os renderiza em uma página web.

Essa arquitetura desacoplada permite que cada serviço seja desenvolvido, implantado e escalado de forma independente.