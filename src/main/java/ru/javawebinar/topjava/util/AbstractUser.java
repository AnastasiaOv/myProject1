package ru.javawebinar.topjava.util;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import ru.javawebinar.topjava.model.Position;
import ru.javawebinar.topjava.model.PositionDict;
import ru.javawebinar.topjava.model.Rate;
import ru.javawebinar.topjava.model.Role;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

/**
 * GKislin
 * 24.04.2015.
 */
public interface AbstractUser {

    Integer getId();

    void setId(Integer id);

    @NotEmpty
    String getName();

    String getSurname();

    String getFirstName();

    String getSecondName();

    void setName(String password);

    List<Rate> getRates();

    Set<Role> getRoles();

    List<PositionDict> getPositionDicts();

    @Email
    @NotEmpty
    String getEmail();

    void setEmail(String password);

    @Size(min = 5, max = 64, message = " must between 5 and 64 characters")
    String getPassword();

    void setPassword(String password);

    @Digits(fraction = 0, integer = 4)
    @NotNull
    int getCaloriesPerDay();

    void setCaloriesPerDay(int caloriesPerDay);

    List<PositionDict> getPositions();
}
