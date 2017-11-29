package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Rate;
import ru.javawebinar.topjava.repository.RateRepository;

import java.util.List;

/**
 * Created by Анастасия on 29.11.2017.
 */
@Repository
public class DataJpaRateRepositoryImpl implements RateRepository {
    @Autowired
    private ProxyRateRepository proxy;

    @Override
    public Rate save(Rate rate) {
        return proxy.save(rate);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }

    @Override
    public Rate get(int id) {
        return proxy.findOne(id);
    }

    @Override
    public List<Rate> getByUser(int userId) {
        return null;
    }

    @Override
    public List<Rate> getAll() {
        return proxy.findAll();
    }
}
