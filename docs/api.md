# API REST — Pingado

## Objetivo

Este documento apresenta os endpoints previstos para a API REST da plataforma Pingado.

A API será responsável por fornecer todos os dados consumidos pelo Front-end e realizar operações relacionadas aos usuários, assinaturas e administração do sistema.

---

# Arquitetura Cliente-Servidor

A comunicação entre Front-end e Back-end acontecerá através de requisições HTTP.

Fluxo:

```
Front-end

↓

HTTP

↓

Spring Boot

↓

Banco de Dados

↓

JSON

↓

Front-end
```

O Front-end não acessa o banco de dados diretamente.

Toda comunicação ocorre através da API.

---

# Base URL

Durante o desenvolvimento:

```
http://localhost:8080/api
```

---

# Endpoints

## Coffee

### Listar cafés

GET

```
/coffees
```

---

### Buscar café por ID

GET

```
/coffees/{id}
```

---

### Cadastrar café

POST

```
/coffees
```

---

### Atualizar café

PUT

```
/coffees/{id}
```

---

### Remover café

DELETE

```
/coffees/{id}
```

---

## Region

GET

```
/regions
```

GET

```
/regions/{id}
```

POST

```
/regions
```

PUT

```
/regions/{id}
```

DELETE

```
/regions/{id}
```

---

## Monthly Selection

GET

```
/monthly-selections
```

GET

```
/monthly-selections/{id}
```

POST

```
/monthly-selections
```

PUT

```
/monthly-selections/{id}
```

DELETE

```
/monthly-selections/{id}
```

---

## Subscription Plans

GET

```
/subscription-plans
```

GET

```
/subscription-plans/{id}
```

POST

```
/subscription-plans
```

PUT

```
/subscription-plans/{id}
```

DELETE

```
/subscription-plans/{id}
```

---

## Users

POST

```
/users
```

Cadastrar usuário.

---

GET

```
/users/{id}
```

Consultar usuário.

---

PUT

```
/users/{id}
```

Atualizar usuário.

---

DELETE

```
/users/{id}
```

Remover usuário.

---

## Authentication

POST

```
/auth/login
```

Realiza autenticação do usuário.

---

POST

```
/auth/logout
```

Encerra a sessão do usuário.

---

## User Subscription

GET

```
/subscriptions
```

---

POST

```
/subscriptions
```

---

PUT

```
/subscriptions/{id}
```

---

DELETE

```
/subscriptions/{id}
```

---

## Payment

GET

```
/payments
```

---

POST

```
/payments
```

---

GET

```
/payments/{id}
```

---

# Padrão de Respostas

A API retornará dados no formato JSON.

Exemplo:

```json
{
  "id": 1,
  "name": "Aurora",
  "description": "Café especial da Chapada Diamantina"
}
```

---

# Versionamento

Inicialmente a API utilizará apenas uma versão.

```
/api
```

Caso necessário, futuramente poderá ser adotado:

```
/api/v1
```

seguido por novas versões como:

```
/api/v2
```

---

# Evoluções Futuras

Conforme a evolução do projeto poderão ser adicionados:

- autenticação JWT;
- autorização por níveis de acesso;
- documentação Swagger/OpenAPI;
- upload de imagens;
- integração com gateway de pagamento;
- paginação;
- filtros;
- cache;
- monitoramento.