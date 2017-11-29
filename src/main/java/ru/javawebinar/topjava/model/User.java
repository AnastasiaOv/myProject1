package ru.javawebinar.topjava.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.service.PositionDictService;
import ru.javawebinar.topjava.service.PositionService;
import ru.javawebinar.topjava.service.RateService;
import ru.javawebinar.topjava.util.AbstractUser;
import ru.javawebinar.topjava.util.RateUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.*;

/**
 * Entity for User
 */
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "unique_email")})
@NamedQueries({
        @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = User.BY_EMAIL, query = "SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.email=?1"),
        @NamedQuery(name = User.ALL_SORTED, query = "SELECT u FROM User u LEFT JOIN FETCH u.roles ORDER BY u.name, u.email"),
})
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User extends NamedEntity implements AbstractUser {

    public static final String DELETE = "User.delete";
    public static final String ALL_SORTED = "User.getAllSorted";
    public static final String BY_EMAIL = "User.getByEmail";

    @Column(name = "email", nullable = false, unique = true)
    protected String email;

    @Column(name = "surname", nullable = false, unique = false)
    protected String surname;

    @Column(name = "firstName", nullable = false, unique = false)
    protected String firstName;

    @Column(name = "secondName", nullable = false, unique = false)
    protected String secondName;

    @Column(name = "password", nullable = false)
    protected String password;

    @Column(name = "enabled", nullable = false)
    protected boolean enabled = true;

    @Column(name = "registered", columnDefinition = "timestamp default now()")
    @NotNull
    protected Date registered = new Date();

    @Transient
    private List<PositionDict> positions;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//    @JsonIgnore
    private Set<Role> roles;

    @Column(name = "calories_per_day", nullable = false, columnDefinition = "default 2000")
    private int caloriesPerDay = 2000;

    @Transient
    private List<PositionDict> positionDicts;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserMeal> userMeals = new LinkedList<>();

    public User(Integer id, String name, String email, String surname, String firstName, String secondName, String password, boolean enabled, Set<Role> roles, List<PositionDict> positionDicts, List<Rate> rates) {
        super(id, name);
        this.email = email;
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
        this.positions = positionDicts;
        this.rates = rates;
    }

    @Override
    public List<Rate> getRates() {
        return rates;
    }


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private List<Rate> rates;

    public User() {
    }

    public User(User u) {
        this(u.getId(), u.getName(), u.getEmail(), u.getSurname(), u.getFirstName(), u.getSecondName(), u.getPassword(), u.isEnabled(), u.getRoles(), u.getPositions(), u.getRates());
    }

    public User(Integer id, String name, String email, String password, boolean enabled, Role role, Role... roles) {
        this(id, name, email, password, enabled, EnumSet.of(role, roles));
    }

    public User(Integer id, String name, String email, String password, boolean enabled, Set<Role> roles) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }


    public User(Integer id, String name, String email, String surname, String firstName, String secondName, String password, boolean enabled, Role role, List<Rate> rates) {
        super(id, name);
        this.email = email;
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
        this.enabled = enabled;
        this.roles = EnumSet.of(role);
        this.rates = rates;
    }




    private String getStringFromList(List<PositionDict> positions) {
        StringBuilder sb = new StringBuilder();
        for (PositionDict position : positions) {
            sb.append(position.getName()).append("\n");
        }
        return sb.toString();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int getCaloriesPerDay() {
        return caloriesPerDay;
    }

    @Override
    public void setCaloriesPerDay(int caloriesPerDay) {
        this.caloriesPerDay = caloriesPerDay;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public List<PositionDict> getPositions() {
        return positions;
    }

    public void setPositions(List<PositionDict> positions) {
        this.positions = positions;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public void setRoles(Role... authorities) {
        setRoles(Arrays.asList(authorities));
    }

    public void setRoles(Collection<Role> authorities) {
        this.roles = EnumSet.copyOf(authorities);
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    @Override
    public List<PositionDict> getPositionDicts() {
        return positionDicts;
    }

    public void setPositionDicts(List<PositionDict> positionDicts) {
        this.positionDicts = positionDicts;
    }

    @Override
    public String toString() {
        return "User{" +
                ", email='" + email + '\'' +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", registered=" + registered +
                ", roles=" + roles +
                ", caloriesPerDay=" + caloriesPerDay +
                ", positions=" + positions +
                ", userMeals=" + userMeals +
                ", rates=" + rates +
                '}';
    }
}
