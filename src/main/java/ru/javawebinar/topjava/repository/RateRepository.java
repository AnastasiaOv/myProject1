package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Rate;
import ru.javawebinar.topjava.model.User;

import java.util.List;

/**
 * Created by Анастасия on 24.11.2017.
 */
public interface RateRepository {
    Rate save(Rate user);

    // false if not found
    boolean delete(int id);

    // null if not found
    Rate get(int id);

    // null if not found
    Rate getByUser(User user);

    List<Rate> getAll();

}
