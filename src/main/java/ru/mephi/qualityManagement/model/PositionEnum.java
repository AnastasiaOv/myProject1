package ru.mephi.qualityManagement.model;

/**
 * Created by Анастасия on 29.11.2017.
 */
public enum PositionEnum {
    NAME_1("руководитель"),
    NAME_2("заместитель руководителя"),
    NAME_3("инспектор отдела кадров"),
    NAME_4("аналитик"),
    NAME_5("руководитель департамента");

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
