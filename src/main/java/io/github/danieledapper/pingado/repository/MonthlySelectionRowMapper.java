package io.github.danieledapper.pingado.repository;

import io.github.danieledapper.pingado.entity.MonthlySelection;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MonthlySelectionRowMapper implements RowMapper<MonthlySelection>
{
    @Override
    public MonthlySelection mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new MonthlySelection(
                rs.getLong("id"),
                rs.getInt("month"),
                rs.getInt("year"),
                rs.getString("title"),
                rs.getString("description")
        );
    }
}
