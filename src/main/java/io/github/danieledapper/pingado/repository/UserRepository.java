package io.github.danieledapper.pingado.repository;

import io.github.danieledapper.pingado.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserRepository
{
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User save(User user)
    {
        String sql = """
                INSERT INTO user(name,
                                 email,
                                 password,
                                 role)
                VALUES(?, ?, ?, ?);
                """;

        jdbcTemplate.update(sql,
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole());

        return user;
    }
}
