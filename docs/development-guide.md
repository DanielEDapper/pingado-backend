# Guia de Desenvolvimento — Pingado

## Objetivo

Este documento reúne os padrões de desenvolvimento adotados no projeto Pingado.

Seu objetivo é manter o código organizado, padronizado e de fácil manutenção durante toda a evolução da aplicação.

Todas as decisões descritas aqui poderão ser revisadas conforme o crescimento do projeto.

---

# Filosofia do Projeto

O Pingado foi desenvolvido como um projeto de aprendizado e portfólio.

Mais importante do que implementar rapidamente é implementar corretamente.

Sempre priorizar:

- simplicidade;
- organização;
- legibilidade;
- boas práticas;
- responsabilidade única;
- evolução incremental.

Evitar adicionar complexidade antes que ela seja realmente necessária.

---

# Organização do Projeto

```
src/main/java/io/github/danieldapper/pingado

config/
controller/
dto/
entity/
exception/
mapper/
repository/
service/
util/
```

Cada pacote possui apenas uma responsabilidade.

---

# Convenções de Nomenclatura

## Classes

Utilizar PascalCase.

Exemplos:

```
Coffee
CoffeeService
CoffeeController
CoffeeRepository
```

---

## Métodos

Utilizar camelCase.

Exemplos:

```
findAll()

findById()

createCoffee()

updateCoffee()

deleteCoffee()
```

---

## Variáveis

Utilizar camelCase.

```
coffeeName

subscriptionPlan

paymentDate
```

---

## Constantes

Utilizar UPPER_CASE.

```
DEFAULT_PAGE_SIZE

MAX_UPLOAD_SIZE
```

---

# Organização das Entidades

Cada entidade deve representar apenas um conceito do domínio.

Evitar colocar regras de negócio dentro das entidades.

As regras ficarão preferencialmente na camada Service.

---

# Controllers

Os Controllers devem ser leves.

Responsabilidades:

- receber requisições;
- validar dados básicos;
- chamar Services;
- retornar respostas HTTP.

Evitar lógica de negócio.

---

# Services

Toda regra de negócio pertence aos Services.

Exemplos:

- validar assinatura;
- cadastrar usuário;
- consultar cafés;
- processar pagamentos.

---

# Repositories

Responsáveis exclusivamente pelo acesso ao banco de dados.

Não devem conter regras de negócio.

---

# DTOs

Sempre utilizar DTOs para comunicação com a API.

Evitar retornar entidades diretamente.

Exemplo:

```
CoffeeResponse

CoffeeRequest
```

---

# Mappers

Responsáveis por converter:

DTO → Entity

Entity → DTO

Essa separação facilita futuras alterações sem impactar a API.

---

# Tratamento de Exceções

Sempre utilizar exceções específicas.

Evitar:

```
throw new Exception();
```

Preferir:

```
CoffeeNotFoundException

UserAlreadyExistsException

SubscriptionNotFoundException
```

---

# Banco de Dados

- utilizar nomes em inglês;
- tabelas no singular;
- chaves primárias chamadas "id";
- chaves estrangeiras seguindo o padrão:

```
region_id

user_id

subscription_plan_id
```

---

# API REST

Seguir os padrões REST.

Exemplos:

```
GET     /coffees

GET     /coffees/{id}

POST    /coffees

PUT     /coffees/{id}

DELETE  /coffees/{id}
```

---

# Git

Utilizar Conventional Commits.

Tipos mais comuns:

```
feat

fix

docs

style

refactor

test

build

chore

perf

ci
```

Exemplos:

```
feat: create Coffee entity

feat: implement Coffee service

fix: validate null subscription

docs: update architecture documentation

refactor: simplify CoffeeRepository

test: add CoffeeService tests

build: configure Maven

chore: update dependencies
```

---

# Branches

Enquanto o projeto estiver sendo desenvolvido por apenas um desenvolvedor, será utilizada apenas a branch:

```
main
```

Caso o projeto cresça, poderão ser adicionadas:

```
develop

feature/*

hotfix/*
```

---

# Testes

Os testes serão implementados utilizando JUnit.

Objetivos:

- validar regras de negócio;
- evitar regressões;
- garantir estabilidade da aplicação.

---

# Evolução Tecnológica

Versão inicial:

- Java
- Spring Boot
- JDBC
- MySQL

Evoluções previstas:

- JPA / Hibernate
- Spring Security
- JWT
- Docker
- Deploy em nuvem
- Swagger/OpenAPI

---

# Princípios

Durante o desenvolvimento do Pingado serão seguidos, sempre que possível, os seguintes princípios:

- Clean Code
- SOLID
- DRY (Don't Repeat Yourself)
- KISS (Keep It Simple, Stupid)
- Separation of Concerns
- Responsabilidade Única

---

# Objetivo Final

O objetivo do projeto não é apenas entregar uma aplicação funcional.

O Pingado deve servir como um projeto de portfólio capaz de demonstrar conhecimentos em:

- Engenharia de Software;
- Arquitetura de Sistemas;
- Java;
- Spring Boot;
- Banco de Dados;
- APIs REST;
- Boas Práticas de Desenvolvimento;
- Integração entre Front-end e Back-end.