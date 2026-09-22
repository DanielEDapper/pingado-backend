package io.github.danieledapper.pingado.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entidade que representa a assinatura de um usuário em um plano.
 */
@Entity
@Table(name = "user_subscription")
public class UserSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subscription_plan_id", nullable = false)
    private SubscriptionPlan subscriptionPlan;

    /** Construtor vazio exigido pelo JPA. */
    public UserSubscription() {
    }

    /**
     * Cria uma assinatura com todos os seus atributos e relacionamentos.
     *
     * @param id identificador da assinatura
     * @param startDate data de início
     * @param endDate data de término, quando houver
     * @param status status da assinatura
     * @param user usuário proprietário da assinatura
     * @param subscriptionPlan plano contratado
     */
    public UserSubscription(Long id, LocalDate startDate, LocalDate endDate, String status,
                            User user, SubscriptionPlan subscriptionPlan) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.user = user;
        this.subscriptionPlan = subscriptionPlan;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public SubscriptionPlan getSubscriptionPlan() { return subscriptionPlan; }
    public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) { this.subscriptionPlan = subscriptionPlan; }
}
