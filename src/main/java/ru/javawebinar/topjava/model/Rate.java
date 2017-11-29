package ru.javawebinar.topjava.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Анастасия on 24.11.2017.
 */
@Entity
@Table(name = "rate")
@NamedQueries({
        @NamedQuery(name = Rate.ALL_SORTED, query = "SELECT r FROM Rate r Where r.id=:id"),
})

public class Rate extends BaseEntity {

    public static final String DELETE = "Rate.delete";
    public static final String ALL_SORTED = "Rate.getByUser";

    public Rate() {
    }

    @Transient
    int userId;

    public Rate(Integer userId, Integer positionId, BigDecimal rateAmount) {
        this.userId = userId;
        this.positionId = positionId;
        this.rateAmount = rateAmount;
    }

    public Rate(Integer position_id, BigDecimal rateAmount) {
        this.positionId = position_id;
        this.rateAmount = rateAmount;
    }

    @Column(name = "position_id")
    private Integer positionId;

    @Column(name = "rate_amount")
    private BigDecimal rateAmount;

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public BigDecimal getRateAmount() {
        return rateAmount;
    }

    public void setRateAmount(BigDecimal rateAmount) {
        this.rateAmount = rateAmount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
