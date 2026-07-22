# Requisitos do Sistema — Pingado

## 1. Requisitos Funcionais

Os requisitos funcionais representam as funcionalidades que o sistema deve disponibilizar aos seus usuários.

---

## RF001 — Cadastro de usuário

O sistema deve permitir que novos usuários criem uma conta informando seus dados pessoais.

Dados inicialmente previstos:

* Nome;
* Email;
* Senha.

---

## RF002 — Autenticação de usuário

O sistema deve permitir que usuários cadastrados realizem login para acessar funcionalidades restritas.

O sistema deverá controlar diferentes níveis de acesso conforme o perfil do usuário.

---

## RF003 — Gerenciamento de cafés

O sistema deve permitir o cadastro e gerenciamento dos cafés especiais disponíveis na plataforma.

Informações previstas:

* Nome do café;
* Origem;
* Região produtora;
* Notas sensoriais;
* Descrição;
* Imagem;
* Outras informações relevantes.

Administradores serão responsáveis pelo gerenciamento dessas informações.

---

## RF004 — Gerenciamento de regiões produtoras

O sistema deve permitir o cadastro e gerenciamento das regiões produtoras de café.

Informações previstas:

* Nome da região;
* Estado;
* Descrição;
* Características da região;
* Altitude;
* Perfil sensorial.

---

## RF005 — Gerenciamento de planos de assinatura

O sistema deve permitir o cadastro e gerenciamento dos planos disponíveis para os clientes.

Cada plano deve possuir informações como:

* Nome;
* Descrição;
* Valor;
* Benefícios;
* Periodicidade.

---

## RF006 — Contratação de assinatura

O sistema deve permitir que usuários escolham um plano e realizem uma assinatura.

Ao contratar um plano, o sistema deverá registrar:

* Usuário responsável;
* Plano escolhido;
* Data de início;
* Status da assinatura.

---

## RF007 — Gerenciamento de assinaturas

O sistema deve permitir o acompanhamento das assinaturas dos usuários.

Possíveis ações:

* Consultar assinatura atual;
* Alterar plano;
* Cancelar assinatura;
* Reativar assinatura.

---

## RF008 — Registro de pagamentos

O sistema deve permitir o registro dos pagamentos relacionados às assinaturas.

Informações previstas:

* Valor;
* Data;
* Status;
* Método de pagamento;
* Assinatura relacionada.

Futuramente poderá existir integração com serviços externos de pagamento.

---

## RF009 — Consulta de cafés disponíveis

O sistema deve permitir que usuários consultem os cafés disponíveis na plataforma.

A consulta poderá apresentar:

* Informações do café;
* Região de origem;
* Notas sensoriais;
* História do produtor;
* Imagens.

---

## RF010 — Área administrativa

O sistema deve possuir funcionalidades administrativas para gerenciamento da plataforma.

Administradores poderão:

* Gerenciar cafés;
* Gerenciar regiões;
* Gerenciar planos;
* Gerenciar usuários;
* Atualizar informações do sistema.

---

# 2. Requisitos Não Funcionais

Os requisitos não funcionais representam características relacionadas à qualidade, segurança e funcionamento do sistema.

---

## RNF001 — Arquitetura organizada

O sistema deve utilizar uma arquitetura organizada em camadas, separando responsabilidades entre:

* Controllers;
* Services;
* Repositories;
* Entidades.

---

## RNF002 — Persistência de dados

O sistema deve utilizar um banco de dados relacional para armazenamento das informações.

Banco inicialmente previsto:

* MySQL.

---

## RNF003 — Segurança

O sistema deve proteger informações sensíveis dos usuários.

Futuramente deverá possuir:

* Controle de autenticação;
* Controle de autorização;
* Criptografia de senhas.

---

## RNF004 — Manutenibilidade

O código deve seguir boas práticas de desenvolvimento visando facilitar futuras alterações e evoluções.

---

## RNF005 — Escalabilidade

A aplicação deve permitir a inclusão de novas funcionalidades futuramente, como:

* Integração com pagamentos;
* Painel administrativo;
* Aplicativo mobile;
* Dashboard de informações.

---

## RNF006 — Testabilidade

O sistema deve possuir testes automatizados para garantir a qualidade das funcionalidades implementadas.

Serão utilizados:

* Testes unitários;
* Testes de integração;
* Mocks quando necessário.

---

# 3. Regras de Negócio

As regras de negócio representam comportamentos e restrições do funcionamento da aplicação.

---

## RN001

Um usuário deve possuir cadastro na plataforma para realizar uma assinatura.

---

## RN002

Um usuário pode possuir diferentes assinaturas ao longo do tempo.

---

## RN003

Uma assinatura deve estar vinculada a um plano existente.

---

## RN004

Uma assinatura deve possuir um status que represente sua situação atual.

Exemplos:

* Ativa;
* Cancelada;
* Pausada;
* Expirada.

---

## RN005

Um café deve possuir uma região produtora associada.

---

## RN006

Somente usuários administradores podem cadastrar ou alterar informações administrativas.

---

## RN007

Um pagamento deve estar relacionado a uma assinatura existente.

---

## RN008

Alterações realizadas nos dados principais do sistema devem preservar a integridade das informações armazenadas.

---

# 4. Observações futuras

Os requisitos apresentados representam a primeira versão da definição do sistema.

Durante a modelagem do domínio e desenvolvimento da aplicação, novos requisitos poderão surgir e os existentes poderão ser revisados conforme a evolução do projeto.
