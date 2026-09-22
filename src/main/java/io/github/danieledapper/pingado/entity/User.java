package io.github.danieledapper.pingado.entity;

import io.github.danieledapper.pingado.enums.UserRole;
import jakarta.persistence.*;

/**
 * Entidade que representa um usuário da plataforma.
 *
 * <p>A tabela utiliza crases porque {@code user} é uma palavra reservada no MySQL.</p>
 */
@Entity
@Table(name = "`user`")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    /** Construtor vazio exigido pelo JPA. */
    public User() {
    }

    /**
     * Cria um usuário com todos os seus atributos.
     *
     * @param id identificador do usuário
     * @param name nome do usuário
     * @param email e-mail único do usuário
     * @param password senha do usuário
     * @param role papel do usuário, como USER ou ADMIN
     */
    public User(Long id, String name, String email, String password, UserRole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public UserRole getRole() { return role; }
    public void setRole(UserRole role) { this.role = role; }
}
