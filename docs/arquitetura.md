# Arquitetura do Sistema — Pingado

## Objetivo

Este documento apresenta a arquitetura utilizada no desenvolvimento do Back-end da plataforma Pingado.

O objetivo é definir como a aplicação será organizada, quais tecnologias serão utilizadas e qual será o fluxo de comunicação entre suas camadas.

A arquitetura foi planejada priorizando simplicidade, organização e facilidade de evolução, permitindo que novas tecnologias sejam incorporadas futuramente sem comprometer a estrutura do sistema.

---

# Arquitetura Geral

O Pingado utilizará uma arquitetura em camadas (Layered Architecture).

Essa arquitetura separa responsabilidades, tornando o sistema mais organizado, testável e de fácil manutenção.

Fluxo da aplicação:

Cliente (Front-end)

↓

Controller

↓

Service

↓

Repository

↓

Banco de Dados

Cada camada possui uma única responsabilidade.

---

# Tecnologias

| Tecnologia | Finalidade |
|------------|------------|
| Java | Linguagem principal da aplicação |
| Spring Boot | Desenvolvimento da API REST |
| JDBC | Persistência inicial dos dados |
| JPA / Hibernate | Evolução futura da persistência |
| MySQL | Banco de dados relacional |
| Maven | Gerenciamento de dependências |
| Git | Versionamento |
| GitHub | Hospedagem do projeto |
| IntelliJ IDEA | Criação e suporte ao projeto Java |
| VS Code | Desenvolvimento e documentação |

---

# Estrutura do Projeto

```
src
└── main
    ├── java
    │   └── io
    │       └── github
    │           └── danieldapper
    │               └── pingado
    │                   ├── config
    │                   ├── controller
    │                   ├── dto
    │                   ├── entity
    │                   ├── exception
    │                   ├── mapper
    │                   ├── repository
    │                   ├── service
    │                   ├── util
    │                   └── PingadoApplication.java
    │
    └── resources
        ├── application.properties
        ├── static
        └── templates
```

---

# Responsabilidade das Pastas

## entity

Contém as entidades do domínio.

Exemplos:

- Coffee
- Region
- MonthlySelection
- User
- SubscriptionPlan
- UserSubscription
- Payment

---

## controller

Responsável por receber as requisições HTTP.

Não contém regras de negócio.

Responsabilidades:

- receber requisições;
- validar dados básicos;
- chamar os serviços;
- retornar respostas HTTP.

---

## service

Camada responsável pelas regras de negócio.

Toda lógica da aplicação deve permanecer nesta camada.

Exemplos:

- cadastrar cafés;
- validar assinaturas;
- calcular informações;
- consultar dados.

---

## repository

Responsável pelo acesso ao banco de dados.

Inicialmente utilizará JDBC.

No futuro poderá ser substituído por Spring Data JPA sem alterar a lógica da aplicação.

---

## dto

Objetos utilizados para entrada e saída de dados da API.

Evita expor diretamente as entidades do sistema.

Exemplos:

- CoffeeRequest
- CoffeeResponse
- LoginRequest
- UserResponse

---

## mapper

Responsável pela conversão entre Entidades e DTOs.

Exemplo:

Coffee → CoffeeResponse

CoffeeRequest → Coffee

Essa separação mantém o código mais organizado e facilita futuras alterações.

---

## exception

Armazena exceções personalizadas da aplicação.

Exemplos:

- CoffeeNotFoundException
- UserNotFoundException
- EmailAlreadyExistsException

---

## config

Centraliza todas as configurações da aplicação.

Exemplos futuros:

- Spring Security
- JWT
- Swagger
- Beans
- CORS

---

## util

Classes auxiliares utilizadas em diferentes partes do sistema.

Exemplos:

- DateUtils
- ValidationUtils

---

# Classe Principal

A classe `PingadoApplication` é o ponto de entrada da aplicação.

Ela contém o método `main()` responsável por iniciar o Spring Boot, configurar o servidor web e carregar todos os componentes do sistema.

---

# Resources

A pasta `resources` contém arquivos que não fazem parte do código Java.

Exemplos:

- configurações da aplicação;
- arquivos estáticos;
- templates (caso sejam utilizados).

O principal arquivo será:

application.properties

Nele serão configurados:

- conexão com banco;
- porta da aplicação;
- configurações do Spring;
- logs;
- futuras integrações.

---

# Fluxo de uma Requisição

```
Front-end

↓

HTTP Request

↓

Controller

↓

Service

↓

Repository

↓

MySQL

↓

Repository

↓

Service

↓

Controller

↓

JSON

↓

Front-end
```

---

# Filosofia da Arquitetura

O Pingado busca uma arquitetura simples e organizada.

Cada camada possui uma responsabilidade única.

Novas funcionalidades deverão ser adicionadas apenas quando representarem uma necessidade real do domínio.

A evolução da aplicação será incremental, permitindo incorporar futuramente tecnologias como JPA, Spring Security, JWT, Docker e serviços externos sem necessidade de grandes refatorações.

O objetivo principal é desenvolver um sistema robusto, de fácil manutenção e que sirva como portfólio completo de desenvolvimento Full Stack.