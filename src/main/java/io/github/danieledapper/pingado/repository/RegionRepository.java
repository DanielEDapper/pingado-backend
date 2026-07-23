package io.github.danieledapper.pingado.repository;

import io.github.danieledapper.pingado.entity.Region;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class RegionRepository {

    private final JdbcTemplate jdbcTemplate;

    public RegionRepository(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Region save(Region region)
    {
        String sql = """
                INSERT INTO region(name,
                                   state,
                                   description,
                                   average_altitude,
                                   sensory_profile)
                VALUES(?, ?, ?, ?, ?);
                """;

        jdbcTemplate.update(sql,
                region.getName(),
                region.getState(),
                region.getDescription(),
                region.getAverageAltitude(),
                region.getSensoryProfile());

        return region;
    }

    public List<Region> findAll()
    {
        String sql = """
                SELECT id,
                       name,
                       state,
                       description,
                       average_altitude,
                       sensory_profile
                FROM region
                """;

        return jdbcTemplate.query(sql, new RegionRowMapper());
    }

    public Optional<Region> findById(Long id)
    {
        String sql = """
                SELECT id,
                       name,
                       state,
                       description,
                       average_altitude,
                       sensory_profile
                FROM region
                WHERE id = ?;
                """;

        List<Region> result = jdbcTemplate.query(sql, new RegionRowMapper(), id);
        return result.stream().findFirst();
    }

    public void update(Long id, Region region)
    {
        String sql = """
                UPDATE region SET name = ?, 
                                  state = ?, 
                                  description = ?, 
                                  average_altitude = ?, 
                                  sensory_profile = ? 
                WHERE id = ?
                """;

        jdbcTemplate.update(sql, region.getName(), region.getState(), region.getDescription(), region.getAverageAltitude(), region.getSensoryProfile(), id);
    }

    public void deleteById(Long id)
    {
        String sql = """
                DELETE FROM region WHERE id = ?
                """;

        jdbcTemplate.update(sql, id);
    }
}
