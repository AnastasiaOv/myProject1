package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Rate;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Анастасия on 24.11.2017.
 */
public interface RateService {
    public Rate save(Rate rate);

    public void delete(int id) throws NotFoundException;

    public Rate get(int id) throws NotFoundException;

    public Rate getByUser(User user) throws NotFoundException;

    public List<Rate> getAll();

    public void update(Rate rate) throws NotFoundException;

    void enable(int id, boolean enable);
}
