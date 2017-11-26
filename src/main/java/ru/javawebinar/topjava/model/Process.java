package ru.javawebinar.topjava.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Анастасия on 26.11.2017.
 */
@Entity
@Table(name = "process")
/*
@NamedNativeQueries({
        @NamedNativeQuery(name = Process.ALL_PROC, query = "SELECT process_name FROM process JOIN position ON process.id = position.process_id WHERE user_id='100001'"),
})

@NamedQueries({
        @NamedQuery(name = Process.ALL_PROC, query = "SELECT p from Process p left join fetch p.position where p.user_id=:id"),
})
*/
public class Process extends NamedEntity {

    static final String ALL_PROC = "Process.allProc";

    @Column(name = "process_name")
    private String processName;

    @Column(name = "level")
    private Integer level;

    @Column(name = "start_time", nullable = false)
    protected LocalDateTime start_time;

    @Column(name = "end_time")
    protected LocalDateTime end_time;

    @Column(name = "definition")
    private String definition;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "process_id", nullable = false)
    private List<Position> positionList;

    public Process() {
    }

    public Process(String processName, Integer level, LocalDateTime start_time, LocalDateTime end_time, String definition, List<Position> positionList) {
        this.processName = processName;
        this.level = level;
        this.start_time = start_time;
        this.end_time = end_time;
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

    @Override
    public String toString() {
        return "Process{" +
                "processName='" + processName + '\'' +
                ", level=" + level +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", definition='" + definition + '\'' +
                ", positionList=" + positionList +
                '}';
    }
}
