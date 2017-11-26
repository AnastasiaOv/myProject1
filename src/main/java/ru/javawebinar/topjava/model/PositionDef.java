package ru.javawebinar.topjava.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Анастасия on 25.11.2017.
 */
@Entity
@Table(name = "position_dict")
public class PositionDef extends BaseEntity {
    @Column(name = "name")
    private String positionName;

    @Column(name = "department")
    private String department;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id", nullable = false)
    private List<Position> positions;

    public PositionDef(String positionName, String department, List<Position> positions) {
        this.positionName = positionName;
        this.department = department;
        this.positions = positions;
    }

    public PositionDef() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
}
