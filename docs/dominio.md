## 1. Visão geral do sistema

O Pingado é uma plataforma de assinatura de cafés especiais brasileiros.

A aplicação tem como objetivo proporcionar uma experiência premium aos consumidores, conectando-os a cafés selecionados de pequenos produtores brasileiros.

Mais do que comercializar café, o sistema busca apresentar a história, origem e características de cada café, valorizando a cultura e a produção nacional.

## 2. Problema que o sistema resolve

Muitos consumidores possuem interesse em conhecer cafés especiais, porém possuem dificuldade em encontrar produtos de qualidade, compreender suas características e descobrir novos produtores.

O Pingado busca facilitar essa descoberta através de uma plataforma de assinatura, oferecendo uma seleção recorrente de cafés especiais acompanhada de informações sobre sua origem e perfil sensorial.

## 3. Objetivo do negócio

O objetivo do Pingado é criar uma plataforma de assinatura onde usuários possam receber cafés especiais selecionados periodicamente.

O sistema deve permitir:

- gerenciamento dos cafés disponíveis;
- gerenciamento das regiões produtoras;
- criação de planos de assinatura;
- cadastro de usuários;
- controle das assinaturas;
- gerenciamento administrativo da plataforma.

## 4. Funcionamento geral

O funcionamento básico da plataforma segue o fluxo:

1. Usuário cria uma conta.
2. Usuário visualiza os planos disponíveis.
3. Usuário escolhe um plano de assinatura.
4. Usuário realiza o pagamento.
5. Sistema ativa sua assinatura.
6. Usuário recebe cafés selecionados conforme o plano contratado.
7. Usuário pode acompanhar informações dos cafés recebidos.

## 5. Atores do sistema

### Cliente

Usuário responsável por consumir a plataforma.

Pode:

- criar conta;
- visualizar cafés;
- consultar regiões produtoras;
- contratar uma assinatura;
- acompanhar sua assinatura.


### Administrador

Responsável pela manutenção da plataforma.

Pode:

- cadastrar cafés;
- editar informações;
- cadastrar regiões;
- gerenciar planos;
- administrar usuários.

## 6. Principais conceitos do domínio

### Coffee

Representa um café especial disponível na plataforma.


### Region

Representa uma região produtora responsável pela origem dos cafés.


### SubscriptionPlan

Representa os planos de assinatura disponíveis.


### User

Representa uma pessoa cadastrada na plataforma.


### UserSubscription

Representa a relação entre um usuário e um plano contratado.


### Payment

Representa os pagamentos realizados relacionados às assinaturas.

## 7. Regras de negócio

- Um usuário pode possuir várias assinaturas ao longo do tempo.
- Uma assinatura deve estar vinculada a um plano existente.
- Um café deve possuir uma região produtora.
- Apenas administradores podem cadastrar novos cafés.
- Um pagamento deve estar relacionado a uma assinatura existente.

## 8. Possíveis evoluções

Futuramente o sistema poderá possuir:

- integração com gateways de pagamento;
- painel administrativo completo;
- sistema de avaliações dos cafés;
- histórico de cafés recebidos;
- recomendações personalizadas;
- aplicativo mobile.