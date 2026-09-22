package io.github.danieledapper.pingado.entity;

import jakarta.persistence.*;

/**
 * Entidade que representa a seleção de café de determinado mês e ano.
 */
@Entity
@Table(name = "monthly_selection")
public class MonthlySelection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer month;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private String title;

    private String description;

    /** Construtor vazio exigido pelo JPA. */
    public MonthlySelection() {
    }

    /**
     * Cria uma seleção mensal com todos os seus atributos.
     *
     * @param id identificador da seleção
     * @param month número do mês
     * @param year ano da seleção
     * @param title título da seleção
     * @param description descrição da seleção
     */
    public MonthlySelection(Long id, Integer month, Integer year, String title, String description) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.title = title;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Integer getMonth() { return month; }
    public void setMonth(Integer month) { this.month = month; }
    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
