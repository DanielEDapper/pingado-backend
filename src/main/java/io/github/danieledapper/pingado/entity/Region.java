package io.github.danieledapper.pingado.entity;

import jakarta.persistence.*;

/**
 * Entidade que representa uma região produtora de café.
 */
@Entity
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String state;

    private String description;

    @Column(name = "average_altitude")
    private Integer averageAltitude;

    @Column(name = "sensory_profile")
    private String sensoryProfile;

    /** Construtor vazio exigido pelo JPA. */
    public Region() {
    }

    /**
     * Cria uma região com todos os seus atributos.
     *
     * @param id identificador da região
     * @param name nome da região
     * @param state estado brasileiro
     * @param description descrição da região
     * @param averageAltitude altitude média da região
     * @param sensoryProfile perfil sensorial associado à região
     */
    public Region(Long id, String name, String state, String description,
                  Integer averageAltitude, String sensoryProfile) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.description = description;
        this.averageAltitude = averageAltitude;
        this.sensoryProfile = sensoryProfile;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getAverageAltitude() { return averageAltitude; }
    public void setAverageAltitude(Integer averageAltitude) { this.averageAltitude = averageAltitude; }
    public String getSensoryProfile() { return sensoryProfile; }
    public void setSensoryProfile(String sensoryProfile) { this.sensoryProfile = sensoryProfile; }
}
