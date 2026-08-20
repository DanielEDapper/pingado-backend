package io.github.danieledapper.pingado.entity;

import jakarta.persistence.*;

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

    public Coffee() {
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