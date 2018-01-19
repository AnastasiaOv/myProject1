package ru.mephi.qualityManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "process_id", nullable = false)
    private Process process;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rate_id", nullable = false)
    private Rate rate;

    public Position(Boolean isOwner, Boolean isExecutor, Boolean isResponsible) {

        this.isOwner = isOwner;
        this.isExecutor = isExecutor;
        this.isResponsible = isResponsible;
    }

    public Position() {
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
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
