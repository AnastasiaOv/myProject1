package ru.javawebinar.topjava.model;

/**
 * Created by Анастасия on 29.11.2017.
 */
public enum PositionEnum {
    NAME_1("название должности"),
    NAME_2("название должности2");

    String s;

    PositionEnum(String s) {
        this.s = s;
    }

    public String getReadableName() {
        return s;
    }

    public String getName() {
        return name();
    }

}
