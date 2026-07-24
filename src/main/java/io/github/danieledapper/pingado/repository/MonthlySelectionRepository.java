package io.github.danieledapper.pingado.repository;

import io.github.danieledapper.pingado.entity.MonthlySelection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MonthlySelectionRepository
{
    private final JdbcTemplate jdbcTemplate;

    public MonthlySelectionRepository(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public MonthlySelection save(MonthlySelection monthlySelection)
    {
        String sql = """
                INSERT INTO monthly_selection(month,
                                              year,
                                              title,
                                              description)
                VALUES(?, ?, ?, ?);
                """;

        jdbcTemplate.update(sql,
                monthlySelection.getMonth(),
                monthlySelection.getYear(),
                monthlySelection.getTitle(),
                monthlySelection.getDescription());


        return monthlySelection;
    }

    public List<MonthlySelection> findAll()
    {
        String sql = """
                SELECT id,
                       month,
                       year,
                       title,
                       description
                FROM month_selection;
                """;

        return jdbcTemplate.query(sql, new MonthlySelectionRowMapper());
    }

    public Optional<MonthlySelection> findById(Long id)
    {
        String sql = """
                SELECT id,
                       month,
                       year,
                       title,
                       description
                FROM month_selection
                WHERE id = ?;
                """;

        List<MonthlySelection> result = jdbcTemplate.query(sql, new MonthlySelectionRowMapper());
        return result.stream().findAny();
    }

    public void update(Long id, MonthlySelection monthlySelection)
    {
        String sql = """
                UPDATE monthly_selection SET month = ?,
                                             year = ?,
                                             title = ?,
                                             description = ?
                WHERE id = ?;
                """;

        jdbcTemplate.update(sql, monthlySelection.getMonth(),
                                 monthlySelection.getYear(),
                                 monthlySelection.getTitle(),
                                 monthlySelection.getDescription(), id);
    }

    public void deleteById(Long id)
    {
        String sql = """
                DELETE FROM monthly_selection WHERE id = ?;
                """;

        jdbcTemplate.update(sql, id);
    }
}
