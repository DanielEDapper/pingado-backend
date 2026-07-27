package io.github.danieledapper.pingado.entity;

public class Coffee
{
    private Long id;
    private String name;
    private String description;
    private String sensoryNotes;
    private String image;
    private Long regionId;
    private Long monthlySelectionId;

    public Coffee(Long id, String name, String description, String sensoryNotes, String image, Long regionId, Long monthlySelectionId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sensoryNotes = sensoryNotes;
        this.image = image;
        this.regionId = regionId;
        this.monthlySelectionId = monthlySelectionId;
    }

    public Coffee()
    {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSensoryNotes() {
        return sensoryNotes;
    }

    public void setSensoryNotes(String sensoryNotes) {
        this.sensoryNotes = sensoryNotes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getMonthlySelectionId() {
        return monthlySelectionId;
    }

    public void setMonthlySelectionId(Long monthlySelectionId) {
        this.monthlySelectionId = monthlySelectionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
