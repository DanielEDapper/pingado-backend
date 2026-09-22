package io.github.danieledapper.pingado.entity;

import jakarta.persistence.*;

/**
 * Entidade que representa um café especial disponível na plataforma.
 */
@Entity
@Table(name = "coffee")
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(name = "sensory_notes")
    private String sensoryNotes;

    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "monthly_selection_id")
    private MonthlySelection monthlySelection;

    /** Construtor vazio exigido pelo JPA. */
    public Coffee() {
    }

    /**
     * Cria um café com todos os seus atributos e relacionamentos.
     *
     * @param id identificador do café
     * @param name nome do café
     * @param description descrição do café
     * @param sensoryNotes notas sensoriais
     * @param image endereço ou referência da imagem
     * @param region região produtora
     * @param monthlySelection seleção mensal associada, quando houver
     */
    public Coffee(Long id, String name, String description, String sensoryNotes, String image,
                  Region region, MonthlySelection monthlySelection) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sensoryNotes = sensoryNotes;
        this.image = image;
        this.region = region;
        this.monthlySelection = monthlySelection;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getSensoryNotes() { return sensoryNotes; }
    public void setSensoryNotes(String sensoryNotes) { this.sensoryNotes = sensoryNotes; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    public Region getRegion() { return region; }
    public void setRegion(Region region) { this.region = region; }
    public MonthlySelection getMonthlySelection() { return monthlySelection; }
    public void setMonthlySelection(MonthlySelection monthlySelection) { this.monthlySelection = monthlySelection; }
}
