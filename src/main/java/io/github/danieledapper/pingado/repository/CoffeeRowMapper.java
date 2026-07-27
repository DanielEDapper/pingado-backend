package io.github.danieledapper.pingado.repository;

import io.github.danieledapper.pingado.entity.Coffee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoffeeRowMapper implements RowMapper<Coffee>
{

    @Override
    public Coffee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Coffee(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("sensory_notes"),
                rs.getString("image"),
                rs.getLong("region_id"),
                rs.getLong("monthly_selection_id")
        );
    }
}
