package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Rate;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Анастасия on 24.11.2017.
 */
public class RateServiceImpl implements RateService {
    @Override
    public Rate save(Rate rate) {
        return null;
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public Rate get(int id) throws NotFoundException {
        return null;
    }

    @Override
    public Rate getByUser(User user) throws NotFoundException {
        return null;
    }

    @Override
    public List<Rate> getAll() {
        return null;
    }

    @Override
    public void update(Rate rate) throws NotFoundException {

    }

    @Override
    public void enable(int id, boolean enable) {

    }
}
