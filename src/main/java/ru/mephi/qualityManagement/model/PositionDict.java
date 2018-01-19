package ru.mephi.qualityManagement.model;

import javax.persistence.*;

/**
 * Created by Анастасия on 27.11.2017.
 */
@Entity
@Table(name = "position_dict")
@NamedQueries({
        @NamedQuery(name = PositionDict.GET_ALL, query = "SELECT p FROM PositionDict p"),})

public class PositionDict extends BaseEntity {

    public static final String GET_ALL = "PositionDict.getAll";

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    public PositionDict() {
    }

    public PositionDict(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PositionDict{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
