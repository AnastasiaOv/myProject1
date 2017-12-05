package ru.javawebinar.topjava.model;

import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Анастасия on 26.11.2017.
 */
@Entity
@Table(name = "process")
public class Process extends BaseEntity {
    @Column(name = "process_name")
    private String processName;

    @Column(name = "level")
    private Integer level;

    @Column(name = "start_time", nullable = false)
    protected LocalDateTime start_time;

    @Column(name = "end_time")
    protected LocalDateTime end_time;

    @Column(name = "description")
    private String definition;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "process_id", nullable = false)
    private List<Position> positionList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "process", fetch = FetchType.EAGER)
    private List<Criteria> criteriaList;

    public Process() {
    }

    public Process(String processName, Integer level, LocalDateTime start_time, LocalDateTime end_time, String definition, List<Position> positionList, List<Criteria> criteriaList) {
        this.processName = processName;
        this.level = level;
        this.start_time = start_time;
        this.end_time = end_time;
        this.definition = definition;
        this.positionList = positionList;
        this.criteriaList = criteriaList;
    }

    public Process(Integer id, String processName, Integer level, LocalDateTime start_time, LocalDateTime end_time, String definition, List<Position> positionList) {
        super(id);
        this.processName = processName;
        this.level = level;
        this.start_time = start_time;
        this.end_time = end_time;
        this.definition = definition;
        this.positionList = positionList;
    }

    public Process(Integer id, String processName, Integer level, LocalDateTime start_time, String definition, List<Position> positionList) {
        super(id);
        this.processName = processName;
        this.level = level;
        this.start_time = start_time;
        this.definition = definition;
        this.positionList = positionList;
    }


    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public LocalDateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalDateTime start_time) {
        this.start_time = start_time;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }

    public List<Criteria> getCriteriaList() {
        return criteriaList;
    }

    public void setCriteriaList(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Override
    public String toString() {
        return "Process{" +
                "processName='" + processName + '\'' +
                ", level=" + level +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", definition='" + definition + '\'' +
                ", positionList=" + positionList +
                ", criteriaList=" + criteriaList +
                '}';
    }
}
