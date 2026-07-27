package io.github.danieledapper.pingado.repository;

import io.github.danieledapper.pingado.entity.Coffee;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

public class CoffeeRepository {
    private final JdbcTemplate jdbcTemplate;

    public CoffeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Coffee> findAll() {
        String sql = """
                SELECT id,
                       name,
                       description,
                       sensory_notes,
                       image,
                       region_id,
                       monthly_selection_id
                FROM coffee
                """;

        return jdbcTemplate.query(sql, new CoffeeRowMapper());
    }

    public Optional<Coffee> findById(Long id) {
        String sql = """
                SELECT id,
                       name,
                       description,
                       sensory_notes,
                       image,
                       region_id,
                       monthly_selection_id
                FROM coffee
                WHERE id = ?
                """;

        return jdbcTemplate.query(sql, new CoffeeRowMapper(), id).stream().findFirst();
    }

    public Coffee save(Coffee coffee) {
        String sql = """
                INSERT INTO coffee (name, description, sensory_notes, image, region_id, monthly_selection_id)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        jdbcTemplate.update(sql,
                coffee.getName(),
                coffee.getDescription(),
                coffee.getSensoryNotes(),
                coffee.getImage(),
                coffee.getRegionId(),
                coffee.getMonthlySelectionId());

        return coffee;
    }

    public void update(Long id, Coffee coffee) {
        String sql = """
                UPDATE coffee
                SET name = ?,
                    description = ?,
                    sensory_notes = ?,
                    image = ?,
                    region_id = ?,
                    monthly_selection_id = ?
                WHERE id = ?
                """;

        jdbcTemplate.update(sql,
                coffee.getName(),
                coffee.getDescription(),
                coffee.getSensoryNotes(),
                coffee.getImage(),
                coffee.getRegionId(),
                coffee.getMonthlySelectionId(),
                id);
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM coffee WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
