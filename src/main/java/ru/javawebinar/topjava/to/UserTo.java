package ru.javawebinar.topjava.to;

import ru.javawebinar.topjava.model.Position;
import ru.javawebinar.topjava.model.PositionDict;
import ru.javawebinar.topjava.model.Rate;
import ru.javawebinar.topjava.util.AbstractUser;

import java.io.Serializable;
import java.util.List;

public class UserTo implements AbstractUser, Serializable {
    protected int id;

    public UserTo() {
    }

    public UserTo(int id, String name, String email, String surname, String firstName, String secondName, int caloriesPerDay, Boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.caloriesPerDay = caloriesPerDay;
        this.isAdmin = isAdmin;

    }

    public UserTo(int id, String name, String email, String surname, String firstName, String secondName, int caloriesPerDay, Boolean isAdmin, List<Position> positions) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.caloriesPerDay = caloriesPerDay;
        this.isAdmin = isAdmin;
        this.position = positions;

    }

    public UserTo(int id, String name, String email, String surname, String firstName, String secondName, int caloriesPerDay, Boolean isAdmin, List<Position> positions,List<PositionDict> positionDicts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.caloriesPerDay = caloriesPerDay;
        this.isAdmin = isAdmin;
        this.position = positions;
        this.positionDicts=positionDicts;
    }

    protected String name;

    protected String email;

    protected String password;

    private String surname;
    private String firstName;
    private String secondName;

    private int caloriesPerDay = 2000;
    private Boolean isAdmin;
    private List<Position> position;
    private List<PositionDict> positionDicts;

    @Override
    public List<Position> getPositions() {
        return position;
    }

    @Override
    public List<PositionDict> getPositionDicts() {
        return positionDicts;
    }

    public void setPosition(List<Position> position) {
        this.position = position;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = (id == null ? 0 : id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public int getCaloriesPerDay() {
        return caloriesPerDay;
    }

    public void setCaloriesPerDay(int caloriesPerDay) {
        this.caloriesPerDay = caloriesPerDay;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {
        return "UserTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", caloriesPerDay=" + caloriesPerDay +
                ", isAdmin=" + isAdmin +
                ", position=" + position +
                '}';
    }
}
