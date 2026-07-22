# Casos de Uso — Pingado

## 1. Introdução

Este documento apresenta os principais casos de uso da plataforma Pingado.

Os casos de uso representam as interações entre os atores do sistema e as funcionalidades disponíveis, servindo como base para a modelagem do domínio, arquitetura e desenvolvimento do backend.

---

# 2. Atores do Sistema

## Cliente

Representa o usuário consumidor da plataforma.

O cliente utiliza o sistema para conhecer cafés especiais, contratar assinaturas e acompanhar sua experiência dentro da plataforma.

Principais responsabilidades:

* Criar conta;
* Realizar login;
* Visualizar cafés;
* Consultar regiões produtoras;
* Escolher planos;
* Realizar assinaturas;
* Acompanhar informações da assinatura.

---

## Administrador

Representa o usuário responsável pelo gerenciamento da plataforma.

Principais responsabilidades:

* Gerenciar cafés;
* Gerenciar regiões produtoras;
* Gerenciar planos;
* Gerenciar usuários;
* Administrar informações do sistema.

---

# 3. Casos de Uso do Cliente

---

# UC001 — Criar conta

## Ator principal

Cliente

## Objetivo

Permitir que um novo usuário seja cadastrado na plataforma.

## Pré-condições

* Usuário ainda não possui cadastro.

## Fluxo principal

1. Usuário acessa a página de cadastro.
2. Usuário informa seus dados pessoais.
3. Sistema valida as informações.
4. Sistema verifica se o email já está cadastrado.
5. Sistema cria o usuário.
6. Sistema confirma o cadastro.

## Possíveis exceções

* Email já utilizado.
* Dados obrigatórios não informados.

---

# UC002 — Realizar login

## Ator principal

Cliente

## Objetivo

Permitir que usuários cadastrados acessem funcionalidades privadas.

## Fluxo principal

1. Usuário informa email e senha.
2. Sistema valida as credenciais.
3. Sistema autentica o usuário.
4. Sistema libera acesso às funcionalidades privadas.

## Possíveis exceções

* Usuário inexistente.
* Senha inválida.

---

# UC003 — Visualizar cafés

## Ator principal

Cliente

## Objetivo

Permitir que usuários conheçam os cafés disponíveis na plataforma.

## Fluxo principal

1. Usuário acessa o catálogo de cafés.
2. Sistema consulta os cafés cadastrados.
3. Sistema retorna as informações dos cafés.

Informações apresentadas:

* Nome;
* Região de origem;
* Produtor;
* Notas sensoriais;
* Descrição;
* Imagem.

---

# UC004 — Consultar regiões produtoras

## Ator principal

Cliente

## Objetivo

Permitir que usuários conheçam a origem dos cafés.

## Fluxo principal

1. Usuário acessa uma região produtora.
2. Sistema apresenta informações da região.

Informações apresentadas:

* Nome;
* Localização;
* História;
* Características;
* Perfil sensorial.

---

# UC005 — Escolher plano de assinatura

## Ator principal

Cliente

## Objetivo

Permitir que o usuário escolha um plano disponível.

## Fluxo principal

1. Usuário acessa os planos disponíveis.
2. Sistema apresenta os planos cadastrados.
3. Usuário seleciona um plano.
4. Sistema apresenta detalhes do plano.

---

# UC006 — Contratar assinatura

## Ator principal

Cliente

## Objetivo

Permitir que um usuário contrate uma assinatura de café.

## Pré-condições

* Usuário deve possuir cadastro.
* Deve existir um plano disponível.

## Fluxo principal

1. Usuário seleciona um plano.
2. Sistema valida o plano escolhido.
3. Sistema cria uma assinatura vinculada ao usuário.
4. Sistema encaminha o pagamento.
5. Sistema recebe confirmação do pagamento.
6. Sistema ativa a assinatura.

## Possíveis exceções

* Plano indisponível.
* Pagamento recusado.

---

# UC007 — Consultar assinatura

## Ator principal

Cliente

## Objetivo

Permitir que o usuário acompanhe sua assinatura atual.

## Fluxo principal

1. Usuário acessa sua área pessoal.
2. Sistema busca suas assinaturas.
3. Sistema apresenta informações.

Informações:

* Plano contratado;
* Status;
* Data de início;
* Próximo pagamento;
* Histórico.

---

# UC008 — Cancelar assinatura

## Ator principal

Cliente

## Objetivo

Permitir que o usuário encerre sua assinatura.

## Fluxo principal

1. Usuário solicita cancelamento.
2. Sistema verifica assinatura ativa.
3. Sistema altera status da assinatura.
4. Sistema registra data de cancelamento.

---

# 4. Casos de Uso do Administrador

---

# UC009 — Cadastrar café

## Ator principal

Administrador

## Objetivo

Permitir o cadastro de novos cafés especiais.

## Fluxo principal

1. Administrador acessa área administrativa.
2. Informa dados do café.
3. Seleciona região produtora.
4. Sistema valida informações.
5. Sistema salva o café.

---

# UC010 — Gerenciar cafés

## Ator principal

Administrador

## Objetivo

Permitir manutenção dos cafés cadastrados.

Operações:

* Criar;
* Consultar;
* Editar;
* Remover.

---

# UC011 — Gerenciar regiões produtoras

## Ator principal

Administrador

## Objetivo

Permitir gerenciamento das regiões produtoras.

Operações:

* Criar região;
* Atualizar informações;
* Consultar regiões;
* Remover região.

---

# UC012 — Gerenciar planos de assinatura

## Ator principal

Administrador

## Objetivo

Permitir gerenciamento dos planos oferecidos.

Operações:

* Criar plano;
* Editar plano;
* Alterar valores;
* Desativar plano.

---

# UC013 — Gerenciar usuários

## Ator principal

Administrador

## Objetivo

Permitir administração dos usuários cadastrados.

Operações:

* Consultar usuários;
* Alterar permissões;
* Bloquear usuários.

---

# 5. Fluxo principal do negócio

## Jornada de assinatura

```
Usuário

↓

Cria conta

↓

Visualiza planos

↓

Escolhe assinatura

↓

Realiza pagamento

↓

Sistema ativa assinatura

↓

Usuário acompanha sua assinatura

↓

Recebe cafés selecionados
```

---

# 6. Observações

Os casos de uso apresentados representam a primeira versão da aplicação.

Durante a evolução do projeto, novos casos poderão ser adicionados conforme novas funcionalidades forem implementadas.
