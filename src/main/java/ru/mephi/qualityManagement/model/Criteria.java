package ru.mephi.qualityManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Анастасия on 04.12.2017.
 */
@Entity
@Table(name = "criteria")
public class Criteria extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "target_value")
    private BigDecimal targetValue;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "process_id", nullable = false)
    private Process process;

    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "reduce_factor")
    private BigDecimal reduceFactor;

    public Criteria() {
    }

    public Criteria(Integer id, String name, String description, BigDecimal value, BigDecimal targetValue, Process process) {
        super(id);
        this.name = name;
        this.description = description;
        this.value = value;
        this.targetValue = targetValue;
        this.process = process;
    }

    public Criteria(Integer id, String name, String description, BigDecimal value, BigDecimal targetValue, Process process, BigDecimal weigth, BigDecimal reduceFactor) {
        super(id);
        this.name = name;
        this.description = description;
        this.value = value;
        this.targetValue = targetValue;
        this.process = process;
        this.weight = weigth;
        this.reduceFactor = reduceFactor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(BigDecimal targetValue) {
        this.targetValue = targetValue;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getReduceFactor() {
        return reduceFactor;
    }

    public void setReduceFactor(BigDecimal reduceFactor) {
        this.reduceFactor = reduceFactor;
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", targetValue=" + targetValue +
                '}';
    }
}
