package ru.javawebinar.topjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by Анастасия on 24.11.2017.
 */
@Entity
@Table(name = "position")
public class Position extends BaseEntity {
    @Column(name = "is_owner")
    private Boolean isOwner;

    @Column(name = "is_executor")
    private Boolean isExecutor;

    @Column(name = "is_responsible")
    private Boolean isResponsible;

    public Position(Boolean isOwner, Boolean isExecutor, Boolean isResponsible) {

        this.isOwner = isOwner;
        this.isExecutor = isExecutor;
        this.isResponsible = isResponsible;
    }

    public Position() {
    }


    public Boolean getOwner() {
        return isOwner;
    }

    public void setOwner(Boolean owner) {
        isOwner = owner;
    }

    public Boolean getExecutor() {
        return isExecutor;
    }

    public void setExecutor(Boolean executor) {
        isExecutor = executor;
    }

    public Boolean getResponsible() {
        return isResponsible;
    }

    public void setResponsible(Boolean responsible) {
        isResponsible = responsible;
    }

    @Override
    public String toString() {
        return "Position{" +
                ", isOwner=" + isOwner +
                ", isExecutor=" + isExecutor +
                ", isResponsible=" + isResponsible;
    }
}
