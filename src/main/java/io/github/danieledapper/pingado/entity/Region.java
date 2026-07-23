package io.github.danieledapper.pingado.entity;

public class Region
{
    private Long id;
    private String name;
    private String state;
    private String description;
    private Integer averageAltitude;
    private String sensoryProfile;

    public Region(Long id, String name, String state, String description, Integer averageAltitude, String sensoryProfile) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.description = description;
        this.averageAltitude = averageAltitude;
        this.sensoryProfile = sensoryProfile;
    }

    public Region()
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAverageAltitude() {
        return averageAltitude;
    }

    public void setAverageAltitude(Integer averageAltitude) {
        this.averageAltitude = averageAltitude;
    }

    public String getSensoryProfile() {
        return sensoryProfile;
    }

    public void setSensoryProfile(String sensoryProfile) {
        this.sensoryProfile = sensoryProfile;
    }
}
