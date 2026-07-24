package io.github.danieledapper.pingado.entity;

public class MonthlySelection
{
    private Long id;
    private Integer month;
    private Integer year;
    private String title;
    private String description;

    public MonthlySelection(Long id, Integer month, Integer year, String title, String description) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.title = title;
        this.description = description;
    }

    public MonthlySelection()
    {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
