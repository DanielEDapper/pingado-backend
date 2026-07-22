# Modelo de Domínio — Pingado

## Objetivo

Este documento apresenta o modelo de domínio da plataforma Pingado.

Seu objetivo é identificar os principais conceitos do negócio e seus relacionamentos, servindo como base para a modelagem do banco de dados e para o desenvolvimento da API.

A modelagem apresentada busca representar o funcionamento atual da plataforma de forma simples, organizada e preparada para futuras evoluções, evitando abstrações desnecessárias na primeira versão do sistema.

---

# Áreas do Domínio

Atualmente o domínio do sistema pode ser dividido em quatro áreas principais.

## Catálogo

Responsável pelas informações dos cafés especiais apresentados na plataforma.

Entidades:

* Coffee
* Region
* MonthlySelection

---

## Usuários

Responsável pelo gerenciamento dos usuários da plataforma.

Entidades:

* User

---

## Assinaturas

Responsável pelos planos oferecidos e pelas assinaturas realizadas pelos usuários.

Entidades:

* SubscriptionPlan
* UserSubscription

---

## Pagamentos

Responsável pelo registro dos pagamentos relacionados às assinaturas.

Entidade:

* Payment

---

# Entidades do Domínio

## Coffee

### Descrição

Representa um café especial disponível na plataforma.

Cada café possui informações sobre sua origem, características sensoriais e faz parte da seleção mensal apresentada aos assinantes.

### Responsabilidades

* armazenar informações do café;
* possuir uma região produtora;
* apresentar notas sensoriais;
* participar de uma seleção mensal.

### Principais atributos

* id
* nome
* descrição
* origem
* altitude
* notasSensoriais
* imagem

### Relacionamentos

* pertence a uma Region;
* participa de uma MonthlySelection.

---

## Region

### Descrição

Representa uma região produtora de cafés especiais.

A região concentra informações próprias, permitindo que diversos cafés compartilhem a mesma origem.

### Responsabilidades

* representar uma região produtora;
* armazenar características da região;
* organizar os cafés produzidos naquela localidade.

### Principais atributos

* id
* nome
* estado
* descrição
* altitudeMedia
* perfilSensorial

### Relacionamentos

* possui vários Coffee.

---

## MonthlySelection

### Descrição

Representa a seleção oficial de cafés apresentada em determinado mês.

Seu objetivo é organizar quais cafés compõem a edição mensal da plataforma.

### Responsabilidades

* identificar a seleção mensal;
* agrupar os cafés daquela edição.

### Principais atributos

* id
* mes
* ano
* titulo
* descricao

### Relacionamentos

* possui vários Coffee.

---

## User

### Descrição

Representa um usuário cadastrado na plataforma.

O usuário poderá acessar funcionalidades restritas, contratar planos e acompanhar sua assinatura.

### Responsabilidades

* autenticação;
* gerenciamento do perfil;
* contratação de assinaturas.

### Principais atributos

* id
* nome
* email
* senha
* role

### Relacionamentos

* possui uma ou mais UserSubscription.

---

## SubscriptionPlan

### Descrição

Representa um plano de assinatura disponível na plataforma.

Cada plano define os benefícios oferecidos ao assinante.

### Responsabilidades

* armazenar informações dos planos;
* definir valores e benefícios.

### Principais atributos

* id
* nome
* descricao
* valor
* periodicidade

### Relacionamentos

* pode estar associado a várias UserSubscription.

---

## UserSubscription

### Descrição

Representa a assinatura realizada por um usuário.

Essa entidade registra qual plano foi contratado e o estado atual da assinatura.

### Responsabilidades

* vincular um usuário a um plano;
* controlar o status da assinatura;
* registrar datas importantes.

### Principais atributos

* id
* dataInicio
* dataFim
* status

### Relacionamentos

* pertence a um User;
* referencia um SubscriptionPlan;
* possui um ou mais Payment.

---

## Payment

### Descrição

Representa um pagamento relacionado a uma assinatura.

Inicialmente será utilizado apenas para registrar pagamentos realizados, permitindo futura integração com gateways de pagamento.

### Responsabilidades

* registrar pagamentos;
* controlar o status do pagamento.

### Principais atributos

* id
* valor
* dataPagamento
* metodoPagamento
* status

### Relacionamentos

* pertence a uma UserSubscription.

---

# Relacionamentos

```text
Region
   │
   │ 1
   │
   └────────────── N
                  │
               Coffee
                  │
                  │
                  N
                  │
                  1
          MonthlySelection


User
 │
 │ 1
 │
 └────────────── N
                │
       UserSubscription
                │
                │ N
                │
                1
       SubscriptionPlan
                │
                │
                1
                │
                N
            Payment
```

---

# Decisões Arquiteturais

Durante a modelagem optou-se por manter um domínio simples e coeso, representando apenas os conceitos necessários para a primeira versão da aplicação.

Entidades como **Order (Compra)**, **Producer**, **Shipment**, **Address** e **Review** foram propositalmente deixadas para futuras evoluções, evitando aumentar a complexidade do sistema sem uma necessidade real.

Essa abordagem permite que o projeto cresça de forma incremental, mantendo uma arquitetura organizada e de fácil manutenção.

---

# Possíveis Evoluções

Conforme a evolução da plataforma, poderão ser adicionadas novas entidades, como:

* Producer;
* Address;
* Order;
* Shipment;
* Review;
* Favorite;
* Notification.

Essas funcionalidades serão avaliadas de acordo com as necessidades futuras do projeto.
