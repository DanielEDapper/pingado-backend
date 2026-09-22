# Development Guide — Pingado Backend

## 1. Objetivo

Este documento define o padrão de desenvolvimento utilizado no backend do Pingado.

O objetivo é manter consistência entre as entidades, repositories, services, DTOs, mappers, controllers, exceptions e testes.

---

## 2. Stack

O projeto utiliza:

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* Banco de dados relacional
* Maven
* REST API
* Spring Security para autenticação e autorização

---

## 3. Estrutura padrão

Uma nova entidade deve seguir, quando aplicável, esta estrutura:

```text
entity/
    Produto.java

repository/
    ProdutoRepository.java

service/
    ProdutoService.java

dto/
    ProdutoRequest.java
    ProdutoResponse.java

mapper/
    ProdutoMapper.java

exception/
    ProdutoNotFoundException.java

controller/
    ProdutoController.java
```

---

## 4. Criando uma nova Entity

A entidade deve representar o modelo persistido.

Exemplo:

```java
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // atributos
}
```

### Recomendações

* Utilizar `Long` para IDs quando esse for o padrão do projeto.
* Utilizar `BigDecimal` para valores monetários.
* Utilizar `LocalDate` para datas sem horário.
* Utilizar relacionamentos JPA quando houver relacionamento entre entidades.
* Definir restrições importantes com anotações JPA.

---

## 5. Criando um Repository

O Repository deve utilizar Spring Data JPA.

Exemplo:

```java
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
```

Não criar `RowMapper`.

Não utilizar `JdbcTemplate` para operações que já podem ser realizadas através do Spring Data JPA.

Consultas específicas podem ser adicionadas ao Repository.

Exemplo:

```java
Optional<User> findByEmail(String email);
```

---

## 6. Criando DTOs

Para cada recurso, utilizar DTOs separados da Entity.

Exemplo:

```text
ProdutoRequest
ProdutoResponse
```

O Request representa os dados recebidos pela API.

O Response representa os dados devolvidos pela API.

Nunca retornar diretamente uma Entity pelo Controller.

---

## 7. Criando o Mapper

O Mapper deve centralizar as conversões:

```text
Request → Entity
Entity → Response
```

Padrão:

```java
public Produto toEntity(ProdutoRequest request) {
    // ...
}

public ProdutoResponse toResponse(Produto produto) {
    // ...
}
```

---

## 8. Criando a Exception

Cada recurso que pode não ser encontrado deve possuir sua própria exception:

```java
public class ProdutoNotFoundException extends RuntimeException {

    public ProdutoNotFoundException(Long id) {
        super("Produto não encontrado: " + id);
    }
}
```

A exception deve ser tratada pelo `GlobalExceptionHandler`.

---

## 9. Criando o Service

O Service concentra as regras de negócio.

Estrutura típica:

```java
@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    // operações
}
```

Para buscas por ID:

---

## 10. Relacionamentos

Quando uma entidade possuir relacionamento com outra entidade, o Service deve garantir que as entidades relacionadas existam antes da persistência.

Exemplo:

```java
Region region = regionRepository.findById(request.regionId())
        .orElseThrow(() -> new RegionNotFoundException(request.regionId()));
```

Depois:



---

## 11. Criando o Controller

O Controller deve delegar o processamento ao Service.

Exemplo:

```java
@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProdutoController {
}
```

Operações REST:

```text
GET       /api/produtos
GET       /api/produtos/{id}
POST      /api/produtos
PUT       /api/produtos/{id}
DELETE    /api/produtos/{id}
```

---

## 12. Tratamento de exceções

Não tratar exceções de negócio repetidamente dentro de cada Controller.

Utilizar:

```java
@RestControllerAdvice
public class GlobalExceptionHandler {
}
```

O Handler deve converter exceções em respostas HTTP padronizadas.

---

## 13. User e segurança

A entidade `User` possui informações relacionadas à autenticação.

A senha:

* pode existir na Entity;
* pode ser recebida no Request;
* deve ser armazenada de forma segura;
* nunca deve aparecer no `UserResponse`.

O papel do usuário é representado pelo enum:

```java
public enum UserRole {
    USER,
    ADMIN
}
```

Na Entity:

```java
@Enumerated(EnumType.STRING)
@Column(nullable = false)
private UserRole role;
```

Não utilizar Strings arbitrárias para roles.

---

## 14. Senhas

Senhas nunca devem ser armazenadas em texto puro.

O fluxo esperado é:

```text
Senha recebida
      ↓
PasswordEncoder
      ↓
Hash
      ↓
Banco
```

A verificação deve ser feita pelo mecanismo de segurança.

---

## 15. Spring Security

O Spring Security será responsável por:

* autenticação;
* identificação do usuário;
* gerenciamento das credenciais;
* autorização;
* proteção dos endpoints;
* integração com os papéis definidos no domínio.

A regra de acesso não deve ser baseada em Strings espalhadas pelo código.

Exemplo:


deve corresponder ao papel definido no domínio.

---

## 16. Padrão para novas funcionalidades

Ao implementar uma nova funcionalidade:

```text
1. Entity
2. Repository
3. Exception
4. Service
5. DTO Request
6. DTO Response
7. Mapper
8. Controller
9. Testes
10. Documentação
```

Quando a funcionalidade envolver autenticação ou autorização:

```text
11. Security configuration
12. Regras de autorização
13. Testes de segurança
```

---

## 17. Checklist antes do commit

Antes de criar um commit:

```text
[ ] Código compila
[ ] Entity revisada
[ ] Repository revisado
[ ] Service revisado
[ ] DTOs revisados
[ ] Mapper revisado
[ ] Controller revisado
[ ] Exceptions revisadas
[ ] GlobalExceptionHandler revisado
[ ] Relacionamentos revisados
[ ] Testes executados
[ ] Swagger revisado
[ ] Nomes padronizados
[ ] Documentação atualizada
```

---

## 18. Padrão de commit

Para implementação completa de uma entidade:

```text
feat: implement <Entidade> end-to-end
```

Exemplo:

```text
feat: implement payment end-to-end
```

Para correções:

```text
fix: correct region response field
```

Para documentação:

```text
docs: update architecture guide
```

---

## 19. Princípio geral

Antes de adicionar uma nova implementação, verificar se ela segue os padrões já utilizados no projeto.

A prioridade é:

```text
Consistência
    ↓
Legibilidade
    ↓
Manutenibilidade
    ↓
Evolução
```

Uma solução mais complexa não deve ser adotada apenas por ser tecnicamente possível.
