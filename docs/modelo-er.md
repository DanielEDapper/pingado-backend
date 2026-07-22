# Modelo Entidade-Relacionamento (MER) — Pingado

## Objetivo

Este documento apresenta a modelagem inicial do banco de dados da plataforma Pingado.

O objetivo é representar como as informações do domínio serão persistidas, definindo entidades, atributos principais, chaves primárias, chaves estrangeiras e relacionamentos.

A modelagem foi desenvolvida considerando a primeira versão da aplicação, priorizando simplicidade, organização e facilidade de evolução.

---

# Entidades

## Region

### Descrição

Representa uma região produtora de cafés especiais.

### Atributos

| Campo            | Tipo    | Observação               |
| ---------------- | ------- | ------------------------ |
| id               | BIGINT  | PK                       |
| name             | VARCHAR | Nome da região           |
| state            | VARCHAR | Estado                   |
| description      | TEXT    | Descrição                |
| average_altitude | INT     | Altitude média da região |
| sensory_profile  | TEXT    | Perfil sensorial         |

---

## Coffee

### Descrição

Representa um café especial apresentado pela plataforma.

### Atributos

| Campo                | Tipo    | Observação            |
| -------------------- | ------- | --------------------- |
| id                   | BIGINT  | PK                    |
| name                 | VARCHAR | Nome                  |
| description          | TEXT    | Descrição             |
| sensory_notes        | VARCHAR | Notas sensoriais      |
| image                | VARCHAR | Caminho da imagem     |
| region_id            | BIGINT  | FK → Region           |
| monthly_selection_id | BIGINT  | FK → MonthlySelection |

---

## MonthlySelection

### Descrição

Representa a seleção mensal de cafés disponibilizada aos assinantes.

### Atributos

| Campo       | Tipo    | Observação      |
| ----------- | ------- | --------------- |
| id          | BIGINT  | PK              |
| month       | INT     | Mês             |
| year        | INT     | Ano             |
| title       | VARCHAR | Nome da seleção |
| description | TEXT    | Descrição       |

---

## User

### Descrição

Representa um usuário cadastrado.

### Atributos

| Campo    | Tipo    | Observação          |
| -------- | ------- | ------------------- |
| id       | BIGINT  | PK                  |
| name     | VARCHAR | Nome                |
| email    | VARCHAR | Único               |
| password | VARCHAR | Senha criptografada |
| role     | VARCHAR | USER ou ADMIN       |

---

## SubscriptionPlan

### Descrição

Representa um plano de assinatura.

### Atributos

| Campo       | Tipo    | Observação         |
| ----------- | ------- | ------------------ |
| id          | BIGINT  | PK                 |
| name        | VARCHAR | Nome               |
| description | TEXT    | Descrição          |
| price       | DECIMAL | Valor              |
| periodicity | VARCHAR | Mensal, anual etc. |

---

## UserSubscription

### Descrição

Representa a assinatura realizada por um usuário.

### Atributos

| Campo                | Tipo    | Observação            |
| -------------------- | ------- | --------------------- |
| id                   | BIGINT  | PK                    |
| start_date           | DATE    | Data de início        |
| end_date             | DATE    | Data final            |
| status               | VARCHAR | Status                |
| user_id              | BIGINT  | FK → User             |
| subscription_plan_id | BIGINT  | FK → SubscriptionPlan |

---

## Payment

### Descrição

Representa um pagamento associado a uma assinatura.

### Atributos

| Campo                | Tipo    | Observação            |
| -------------------- | ------- | --------------------- |
| id                   | BIGINT  | PK                    |
| payment_date         | DATE    | Data                  |
| amount               | DECIMAL | Valor                 |
| payment_method       | VARCHAR | Método                |
| status               | VARCHAR | Status                |
| user_subscription_id | BIGINT  | FK → UserSubscription |

---

# Relacionamentos

| Origem           | Cardinalidade | Destino          |
| ---------------- | ------------- | ---------------- |
| Region           | 1 : N         | Coffee           |
| MonthlySelection | 1 : N         | Coffee           |
| User             | 1 : N         | UserSubscription |
| SubscriptionPlan | 1 : N         | UserSubscription |
| UserSubscription | 1 : N         | Payment          |

---

# Observações

Esta modelagem representa a primeira versão do banco de dados do Pingado.

Relacionamentos mais complexos, como muitos-para-muitos, tabelas intermediárias e novas entidades, poderão ser adicionados futuramente conforme a evolução do sistema.

O objetivo desta primeira versão é manter uma estrutura simples, consistente e alinhada às necessidades atuais da plataforma.
