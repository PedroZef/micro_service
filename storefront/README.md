# Microserviço: Storefront

Este é o microserviço `storefront`, responsável por exibir os produtos disponíveis em uma vitrine web. Ele consome os dados do microserviço `warehouse` para obter a lista de produtos.

## Tecnologias Utilizadas

-   **Java 17**: Versão da linguagem de programação.
-   **Spring Boot**: Framework para criação de aplicações Java.
-   **Spring Web**: Para criação de endpoints web.
-   **Thymeleaf**: Motor de templates para renderizar as páginas web.
-   **Gradle**: Ferramenta de automação de compilação.
-   **H2 Database**: Banco de dados em memória (usado para fins de demonstração no `storefront`).

## Pré-requisitos

Antes de iniciar o `storefront`, certifique-se de que você possui:

1.  **Java 17** ou superior instalado.
2.  O **microserviço `warehouse`** em execução. O `storefront` depende dele para funcionar.
3.  O `warehouse` deve estar acessível na URL configurada no `application.properties` (por padrão: `http://localhost:8082/api/produtos`).

## Configuração

A comunicação entre o `storefront` e o `warehouse` é configurada no arquivo `src/main/resources/application.properties`.

```properties
# URL da API do microserviço warehouse
warehouse.api.url=http://localhost:8082/api/produtos
```

Se o seu serviço `warehouse` estiver rodando em uma porta ou endereço diferente, altere esta linha.

## Como Executar

1.  **Clone este repositório:**

    ```bash
    git clone <url-do-repositorio>
    cd storefront
    ```

2.  **Execute o microserviço `warehouse`:** Siga as instruções no `README.md` do projeto `warehouse` para iniciá-lo.

3.  **Execute o microserviço `storefront`:**
    Você pode iniciar a aplicação usando o Gradle Wrapper.

    No Windows:

    ```bash
    gradlew bootRun
    ```

    No Linux ou macOS:

    ```bash
    ./gradlew bootRun
    ```

4.  **Acesse a vitrine:**
    Após a inicialização, acesse a seguinte URL no seu navegador:

## Visualiza os produtos disponíveis na vitrine.

[http://localhost:8082/storefront](http://localhost:8082/storefront)

-   Ver
-   Adicionar
-   Editar
-   Deletar

## Como Funciona

1.  O usuário acessa a página principal (`/`) do `storefront`.
2.  O `Controller` do `storefront` faz uma requisição `GET` para a API do `warehouse` (`/api/produtos`).
3.  O `warehouse` retorna a lista de produtos em formato JSON.
4.  O `storefront` recebe os dados, os processa e os injeta na página `index.html` usando o Thymeleaf.
5.  A página é renderizada e exibida para o usuário.

Se o `storefront` não conseguir se conectar ao `warehouse`, uma mensagem de erro será exibida na página.

[http://localhost:8082/h2-console-storefront](http://localhost:8082/h2-console-storefront) 2. **Credenciais de Acesso**: - **JDBC URL**: `jdbc:h2:file:./warehouse` - **User Name**: `sa` - **Password**: `guest` 3. **Clique em "Connect"**.
