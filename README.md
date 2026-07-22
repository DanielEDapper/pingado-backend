# ☕ Pingado Backend

API REST responsável pelo gerenciamento da plataforma **Pingado**, uma aplicação de assinatura de cafés especiais brasileiros.

O projeto tem como objetivo conectar consumidores a cafés selecionados de pequenos produtores do Brasil, permitindo o gerenciamento de cafés, regiões produtoras, planos de assinatura, usuários e demais funcionalidades necessárias para uma plataforma completa.

Este projeto faz parte da construção de um sistema Full Stack, sendo o backend responsável pelas regras de negócio, persistência de dados e comunicação com o frontend.

---

# 🎯 Objetivo do projeto

O objetivo do Pingado Backend é desenvolver uma API organizada e escalável utilizando boas práticas de desenvolvimento de software.

Durante o desenvolvimento serão aplicados conceitos como:

* Arquitetura em camadas;
* Programação Orientada a Objetos;
* Modelagem de domínio;
* APIs REST;
* Persistência de dados;
* Testes automatizados;
* Boas práticas de organização de código.

---

# 🚀 Tecnologias utilizadas

## Backend

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* Maven

## Banco de dados

* MySQL

## Testes

* JUnit
* Mockito

## Ferramentas

* IntelliJ IDEA
* Visual Studio Code
* Git
* GitHub
* Postman

---

# 🏗️ Arquitetura

O projeto seguirá inicialmente uma arquitetura baseada em camadas:

```
Controller

↓

Service

↓

Repository

↓

Database
```

Responsabilidades:

### Controller

Responsável por receber as requisições HTTP e retornar respostas para o cliente.

### Service

Responsável pelas regras de negócio da aplicação.

### Repository

Responsável pela comunicação com o banco de dados.

### Database

Responsável pelo armazenamento persistente das informações.

---

# 📂 Estrutura do projeto

```
pingado-backend

├── src
│
├── docs
│   ├── dominio.md
│   ├── requisitos.md
│   ├── casos-de-uso.md
│   ├── modelo-er.md
│   └── arquitetura.md
│
├── README.md
└── pom.xml
```

---

# ☕ Domínio do sistema

O Pingado trabalha com o conceito de assinatura de cafés especiais.

Principais conceitos:

* Cafés especiais;
* Regiões produtoras;
* Produtores;
* Planos de assinatura;
* Usuários;
* Pagamentos;
* Histórico de assinaturas.

A modelagem do domínio será construída antes da implementação, buscando representar corretamente as regras do negócio.

---

# 📌 Funcionalidades previstas

## Cafés

* Cadastro de cafés;
* Consulta de cafés disponíveis;
* Associação com regiões produtoras;
* Informações sensoriais.

## Assinaturas

* Cadastro de planos;
* Gerenciamento de assinaturas dos usuários;
* Controle de status da assinatura.

## Usuários

* Cadastro;
* Login;
* Controle de níveis de acesso.

## Administração

* Gerenciamento de cafés;
* Gerenciamento de regiões;
* Gerenciamento de planos.

---

# 🧪 Testes

O projeto utilizará testes automatizados para garantir a qualidade da aplicação.

Serão utilizados:

* Testes unitários;
* Testes de integração;
* Mocks quando necessário.

---

# 📚 Documentação

Toda a documentação de arquitetura e modelagem do projeto estará disponível na pasta:

```
/docs
```

Documentos principais:

* Visão geral do sistema;
* Requisitos;
* Casos de uso;
* Modelo de domínio;
* Modelo entidade-relacionamento;
* Decisões arquiteturais.

---

# 📈 Evolução futura

Possíveis melhorias:

* Spring Security;
* JWT;
* Docker;
* Deploy em nuvem;
* Integração com serviços de pagamento;
* Painel administrativo;
* Dashboard de métricas;
* Migração para arquiteturas mais avançadas.

---

# 👨‍💻 Desenvolvimento

Projeto desenvolvido como estudo prático de desenvolvimento Full Stack, com foco em backend Java e arquitetura de software.

O objetivo é construir uma aplicação completa aplicando conceitos utilizados no desenvolvimento profissional.
