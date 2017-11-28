package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Rate;

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
    List<Rate> getByUser(int userId);

    List<Rate> getAll();

}
