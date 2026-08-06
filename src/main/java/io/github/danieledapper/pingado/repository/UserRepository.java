package io.github.danieledapper.pingado.repository;

import io.github.danieledapper.pingado.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class UserRepository
{
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll() {
        String sql = """
                SELECT id,
                       name,
                       email,
                       password,
                       role
                FROM user
                """;

        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    public Optional<User> findById(Long id) {
        String sql = """
                SELECT id,
                       name,
                       email,
                       password,
                       role
                FROM `user`
                WHERE id = ?
                """;

        return jdbcTemplate.query(sql, new UserRowMapper(), id).stream().findFirst();
    }

    public Optional<User> findByEmail(String email) {
        String sql = """
                SELECT id,
                       name,
                       email,
                       password,
                       role
                FROM `user`
                WHERE email = ?
                """;

        return jdbcTemplate.query(sql, new UserRowMapper(), email).stream().findFirst();
    }

    public User save(User user) {
        String sql = """
                INSERT INTO `user` (name, email, password, role)
                VALUES (?, ?, ?, ?)
                """;

        jdbcTemplate.update(sql,
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole());

        return user;
    }

    public void update(Long id, User user) {
        String sql = """
                UPDATE `user`
                SET name = ?,
                    email = ?,
                    password = ?,
                    role = ?
                WHERE id = ?
                """;

        jdbcTemplate.update(sql,
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                id);
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM `user` WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
