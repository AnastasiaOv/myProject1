package ru.javawebinar.topjava.to;

import ru.javawebinar.topjava.model.Position;
import ru.javawebinar.topjava.model.PositionDict;
import ru.javawebinar.topjava.model.Rate;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.util.AbstractUser;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class UserTo implements AbstractUser, Serializable {
    protected int id;

    public UserTo() {
    }

    public UserTo(int id, String name, String email, String surname, String firstName, String secondName, int caloriesPerDay) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.caloriesPerDay = caloriesPerDay;
    }

    public UserTo(int id, String name, String email, String surname, String firstName, String secondName, int caloriesPerDay, List<Rate> rates) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.caloriesPerDay = caloriesPerDay;
        this.rates = rates;
    }

    public UserTo(int id, String name, String email, String surname, String firstName, String secondName, int caloriesPerDay, List<PositionDict> positionDicts, List<Rate> rates) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.caloriesPerDay = caloriesPerDay;
        this.rates = rates;
        this.positions = positionDicts;
    }

    public UserTo(int id, String name, String email, String surname, String firstName, String secondName, int caloriesPerDay,
                  Set<Role> roles, List<Rate> rates, List<PositionDict> positions) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.caloriesPerDay = caloriesPerDay;
        this.rates = rates;
        this.positions = positions;
        this.roles = roles;
    }

    protected String name;

    protected String email;

    protected String password;

    private String surname;
    private String firstName;
    private String secondName;

    private int caloriesPerDay = 2000;
    private List<PositionDict> positions;
    private List<Rate> rates;
    private Set<Role> roles;

    @Override
    public List<PositionDict> getPositionDicts() {
        return positions;
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

    @Override
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public List<Rate> getRates() {
        return this.rates;
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

    @Override
    public List<PositionDict> getPositions() {
        return positions;
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
                ", positions=" + positions +
                ", rates=" + rates +
                ", roles=" + roles +
                '}';
    }
}
