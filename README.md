
# API Fault Tolerance com Quarkus

Este repositório contém dois projetos Java Quarkus demonstrando o uso da API de Fault Tolerance SmallRye. Os projetos foram apresentados em um Meetup para a Comunidade Java da Minsait, focando em como construir aplicações resilientes com Quarkus.

## :file_folder: Projetos

### :snail: Demora

O projeto `Demora` é uma aplicação Quarkus simples que simula uma resposta lenta de servidor. 

- **URL do Endpoint**: `/devagar`
- **Método**: GET
- **Resposta**: Retorna a string "Demorei muito..." após uma simulação de demora de 3 segundos usando `Thread.sleep`.

**Configurações**:
- **Build Tool**: Maven
- **Java Versão**: 21
- **Dependências**: Nenhuma
- **Porta de acesso**: 8081 (configurado em `application.properties`)

### :computer: Demora_client

O projeto `Demora_client` é uma aplicação Quarkus que consome a API do projeto `Demora`, demonstrando a implementação da API de Fault Tolerance SmallRye.

**Dependências**:
- REST
- REST JSON-B
- REST Client
- REST Client JSON-B
- SmallRye Fault Tolerance

**Características**:
- Interface `DemoraService` com anotação `@RegisterRestClient` apontando para `http://localhost:8081/devagar`.
- Métodos `getDevagar()` e um método de fallback, ambos implementados para demonstrar os padrões de fault tolerance como `@Timeout`, `@Retry`, `@Fallback`, e `@CircuitBreaker`.

## :gear: Tecnologias Utilizadas

- Quarkus
- Maven
- Java 21
- SmallRye Fault Tolerance

## :bookmark_tabs: Como Executar

Para executar qualquer um dos projetos, siga os passos abaixo:

1. Clone o repositório.
2. Navegue até a pasta do projeto desejado (`Demora` ou `Demora_client`).
3. Execute o comando `./mvnw quarkus:dev` para iniciar a aplicação em modo de desenvolvimento.

## :speech_balloon: Sobre o Meetup

Este projeto foi apresentado em um Meetup organizado pela Comunidade Java da Minsait, focando na construção de aplicações resilientes e na demonstração dos recursos da API de Fault Tolerance SmallRye com Quarkus.

---

Desenvolvido com :heart: pela Comunidade Java da Minsait.
