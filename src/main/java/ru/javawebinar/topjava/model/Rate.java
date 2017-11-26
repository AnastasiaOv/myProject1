package ru.javawebinar.topjava.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Анастасия on 24.11.2017.
 */
@Entity
@Table(name="rate")
@NamedQueries({

})

public class Rate extends BaseEntity{

    public static final String DELETE = "Rate.delete";

    public Rate() {
    }

    public Rate(Integer position_id, BigDecimal rate_amount) {
        this.position_id = position_id;
        this.rate_amount = rate_amount;
    }

    @Column(name = "position_id")

    private Integer position_id;

    @Column(name = "rate_amount")
    private BigDecimal rate_amount;

    public Integer getPosition_id() {
        return position_id;
    }

    public void setPosition_id(Integer position_id) {
        this.position_id = position_id;
    }

    public BigDecimal getRate_amount() {
        return rate_amount;
    }

    public void setRate_amount(BigDecimal rate_amount) {
        this.rate_amount = rate_amount;
    }


}
