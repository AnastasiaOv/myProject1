package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.PositionDict;
import ru.javawebinar.topjava.model.Rate;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Анастасия on 24.11.2017.
 */
public interface RateService {
    Rate save(Rate rate, int userId);

    void delete(int id) throws NotFoundException;

    Rate get(int id, int userId) throws NotFoundException;

    List<Rate> getByUserId(int userId) throws NotFoundException;

    List<Rate> getByPositionName(List<PositionDict> positions) throws NotFoundException;

    List<Rate> getAll();

    Rate createOrUpdate(Rate rate, int userId) throws NotFoundException;

    Rate update(Rate rate, int userId);
}
