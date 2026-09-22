# Arquitetura do Projeto — Pingado Backend

## 1. Visão geral

O backend do Pingado utiliza uma arquitetura em camadas baseada em **Spring Boot**, **Spring Data JPA** e **Hibernate**, buscando separar responsabilidades e facilitar manutenção, testes e evolução do sistema.

A estrutura principal segue o fluxo:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
JPA / Hibernate
    ↓
Banco de Dados
```

As entidades do domínio são representadas por classes JPA e os acessos ao banco são realizados através de interfaces `JpaRepository`.

---

## 2. Estrutura de pacotes

A organização atual do projeto segue a separação por responsabilidade:

```text
src/main/java/io/github/danieledapper/pingado/

├── controller/
├── dto/
├── entity/
├── exception/
├── mapper/
├── repository/
├── service/
└── PingadoApplication.java
```

### Responsabilidade de cada camada

| Pacote       | Responsabilidade                                 |
| ------------ | ------------------------------------------------ |
| `entity`     | Representação das entidades persistidas no banco |
| `repository` | Acesso e operações de persistência               |
| `service`    | Regras de negócio e orquestração                 |
| `dto`        | Objetos utilizados na entrada e saída da API     |
| `mapper`     | Conversão entre Entity e DTO                     |
| `controller` | Exposição dos endpoints REST                     |
| `exception`  | Exceções de negócio e tratamento global          |

---

## 3. Entity

As classes do pacote `entity` representam as entidades persistidas no banco de dados.

As entidades utilizam JPA:

```java
@Entity
@Table(name = "coffee")
public class Coffee {
}
```

A identificação dos registros utiliza `@Id` e `@GeneratedValue` quando aplicável.

Exemplo:

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

### Entidades atuais

```text
Region
MonthlySelection
Coffee
User
SubscriptionPlan
UserSubscription
Payment
```

---

## 4. Persistência com JPA

O projeto utiliza **Spring Data JPA** para acesso ao banco.

Os repositories normalmente seguem o padrão:

```java
@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
```

Com isso, operações comuns de persistência são fornecidas pelo próprio Spring Data:

```text
findAll()
findById()
save()
deleteById()
existsById()
```

Consultas específicas podem ser adicionadas ao repository conforme a necessidade do domínio.

---

## 5. JPA e Hibernate

O JPA define o padrão de persistência utilizado pela aplicação, enquanto o Hibernate atua como implementação do JPA.

O fluxo pode ser representado como:

```text
Service
   ↓
JpaRepository
   ↓
Spring Data JPA
   ↓
Hibernate
   ↓
Banco de Dados
```

O mapeamento entre objetos Java e tabelas do banco é realizado pelo Hibernate através das anotações JPA.

---

## 6. Relacionamentos

Os relacionamentos entre entidades são representados utilizando as anotações JPA.

### Coffee

```text
Coffee
 ├── Region
 └── MonthlySelection
```

Representado por:

```java
@ManyToOne
@JoinColumn(name = "region_id")
private Region region;

@ManyToOne
@JoinColumn(name = "monthly_selection_id")
private MonthlySelection monthlySelection;
```

`monthlySelection` pode ser opcional quando definido dessa forma no modelo.

### UserSubscription

```text
UserSubscription
 ├── User
 └── SubscriptionPlan
```

### Payment

```text
Payment
 └── UserSubscription
```

Os relacionamentos devem ser utilizados para representar o domínio, evitando armazenar manualmente apenas IDs quando a relação entre entidades faz parte do modelo JPA.

---

## 7. Repository

A camada `repository` é responsável pelo acesso aos dados.

O repository não deve conter regras de negócio.

Exemplo:

```java
@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
}
```

Quando uma consulta específica for necessária, ela pode ser declarada no repository.

Exemplo:

```java
Optional<User> findByEmail(String email);
```

---

## 8. Service

A camada `service` concentra as regras de negócio.

Exemplo de fluxo:

```text
Controller
    ↓
Service
    ↓
Repository
```

O Service deve:

* validar regras de negócio;
* buscar entidades relacionadas;
* tratar entidades inexistentes;
* coordenar operações entre repositories;
* converter DTOs através dos mappers;
* impedir que regras de negócio fiquem no Controller.

Exemplo:

```java
Region region = repository.findById(id)
        .orElseThrow(() -> new RegionNotFoundException(id));
```

---

## 9. DTOs

Os DTOs são utilizados para controlar os dados que entram e saem da API.

Cada recurso deve possuir DTOs apropriados para requisição e resposta.

Exemplo:

```text
CoffeeRequest
CoffeeResponse
```

Os DTOs não devem ser utilizados como entidades JPA.

Essa separação evita que a estrutura interna do banco seja exposta diretamente pela API.

---

## 10. Mapper

Os mappers são responsáveis pela conversão entre Entity e DTO.

Padrão utilizado:

```text
Request
   ↓
toEntity()
   ↓
Entity
```

e:

```text
Entity
   ↓
toResponse()
   ↓
Response
```

Exemplo:

```java
public Coffee toEntity(CoffeeRequest request) {
    // conversão
}

public CoffeeResponse toResponse(Coffee coffee) {
    // conversão
}
```

---

## 11. Controller

Os Controllers são responsáveis exclusivamente pela exposição da API REST.

Padrão:

```java
@RestController
@RequestMapping("/api/coffees")
public class CoffeeController {
}
```

O Controller deve:

* receber requisições HTTP;
* validar entrada através dos mecanismos apropriados;
* chamar o Service;
* retornar DTOs;
* definir os status HTTP adequados.

O Controller não deve acessar diretamente o Repository.

---

## 12. Tratamento de exceções

O projeto utiliza exceções específicas de domínio e um tratamento global através de `@RestControllerAdvice`.

Fluxo:

```text
Service
   ↓
Exception
   ↓
GlobalExceptionHandler
   ↓
ErrorResponse
```

Exceções de recurso não encontrado devem seguir o padrão:

```text
<Entity>NotFoundException
```

Exemplo:

```text
CoffeeNotFoundException
UserNotFoundException
PaymentNotFoundException
```

---

## 13. Validação de relacionamentos

Quando uma entidade depende de outra, o Service deve verificar a existência da entidade relacionada antes da persistência.

Exemplo:

```text
Coffee
 └── regionId
       ↓
RegionRepository
       ↓
Region encontrada?
       ↓
Coffee criada
```

Caso a entidade relacionada não exista, uma exceção apropriada deve ser lançada.

---

## 14. Valores monetários

Valores monetários devem utilizar:


Nunca utilizar `double` ou `float` para representar valores financeiros.

Exemplo:

```java
private BigDecimal price;
```

---

## 15. Datas

Datas que representam apenas uma data de calendário devem utilizar:


Exemplo:

```java
private LocalDate paymentDate;
```

---

## 16. Papéis de usuário

Os papéis de usuário são definidos através de um enum de domínio:

```java
public enum UserRole {
    USER,
    ADMIN
}
```

Na entidade:

```java
@Enumerated(EnumType.STRING)
@Column(nullable = false)
private UserRole role;
```

O uso de `EnumType.STRING` mantém os valores legíveis no banco e evita dependência da posição dos elementos do enum.

Os papéis serão utilizados posteriormente pelo Spring Security para controle de autorização.

---

## 17. Segurança

A autenticação e autorização serão implementadas através do Spring Security.

A arquitetura de segurança deverá separar:

```text
Autenticação
    ↓
Quem é o usuário?

Autorização
    ↓
O que esse usuário pode fazer?
```

O controle de acesso deverá utilizar os papéis definidos pelo domínio.

---

## 18. Princípios da arquitetura

O projeto deve preservar os seguintes princípios:

1. Controllers não acessam repositories diretamente.
2. Regras de negócio ficam nos Services.
3. Entities representam o domínio persistido.
4. DTOs controlam os dados expostos pela API.
5. Mappers realizam conversões entre DTOs e Entities.
6. Repositories são responsáveis pela persistência.
7. Exceções de negócio são tratadas globalmente.
8. Relacionamentos do domínio devem ser representados através do JPA.
9. Valores monetários utilizam `BigDecimal`.
10. Datas de calendário utilizam `LocalDate`.
11. Papéis de usuário utilizam `Enum`.
12. Segurança deve ser aplicada em uma camada própria, sem misturar regras de autenticação com regras de negócio.
