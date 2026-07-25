package io.github.danieledapper.pingado.entity;

public class Coffee
{
    private Long id;
    private String name;
    private String sensory_notes;
    private String image;
    private Long region_id;
    private Long monthly_selection_id;

    public Coffee(Long id, String name, String sensory_notes, String image, Long region_id, Long monthly_selection_id) {
        this.id = id;
        this.name = name;
        this.sensory_notes = sensory_notes;
        this.image = image;
        this.region_id = region_id;
        this.monthly_selection_id = monthly_selection_id;
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

    public String getSensory_notes() {
        return sensory_notes;
    }

    public void setSensory_notes(String sensory_notes) {
        this.sensory_notes = sensory_notes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Long region_id) {
        this.region_id = region_id;
    }

    public Long getMonthly_selection_id() {
        return monthly_selection_id;
    }

    public void setMonthly_selection_id(Long monthly_selection_id) {
        this.monthly_selection_id = monthly_selection_id;
    }
}
