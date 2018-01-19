package ru.mephi.qualityManagement.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Анастасия on 18.01.2018.
 */
@Entity
@Table(name = "target_criteria")
public class TargetCriteria extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private BigDecimal weigth;

    @Column(name = "target_value")
    private BigDecimal targetValue;

    @Column(name = "process_name")
    private String processName;

    public TargetCriteria() {
    }

    public TargetCriteria(String name, BigDecimal weigth, BigDecimal targetValue, String processName) {
        this.name = name;
        this.weigth = weigth;
        this.targetValue = targetValue;
        this.processName = processName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getWeigth() {
        return weigth;
    }

    public void setWeigth(BigDecimal weigth) {
        this.weigth = weigth;
    }

    public BigDecimal getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(BigDecimal targetValue) {
        this.targetValue = targetValue;
    }

    public String getProcess() {
        return processName;
    }

    public void setProcess(String processName) {
        this.processName = processName;
    }

    @Override
    public String toString() {
        return "TargetCriteria{" +
                "name='" + name + '\'' +
                ", weigth=" + weigth +
                ", targetValue=" + targetValue +
                '}';
    }
}
