package ru.javawebinar.topjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Анастасия on 24.11.2017.
 */
@Entity
@Table(name = "rate")
public class Rate extends BaseEntity {

    public Rate() {
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "process", fetch = FetchType.EAGER)
    private List<Position> positionList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rate(Integer id, Integer positionId, BigDecimal rateAmount) {
        super(id);
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

    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }
}
