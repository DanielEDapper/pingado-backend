package io.github.danieledapper.pingado.repository;

import io.github.danieledapper.pingado.entity.Region;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegionRowMapper implements RowMapper<Region>
{

    @Override
    public Region mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Region(rs.getLong("id"), rs.getString("name"), rs.getString("state"), rs.getString("description"), rs.getInt("average_altitude"), rs.getString("sensory_profile"));
    }
}
