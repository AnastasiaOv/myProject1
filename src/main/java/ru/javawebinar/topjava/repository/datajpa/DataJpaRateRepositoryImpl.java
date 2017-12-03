package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProxyUserRepository userProxy;

    @Override
    public Rate save(Rate rate, int userId) {
        rate.setUser(userProxy.getOne(userId));
        if (!rate.isNew() && get(rate.getId(), userId) == null) {
            return null;
        }
        return proxy.save(rate);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }

    @Override
    public Rate get(int id, int userId) {
        return proxy.get(id, userId);
    }

    @Override
    public List<Rate> getByUserId(int userId) {
        return proxy.getByUserId(userId);
    }

     @Override
    public List<Rate> getAll() {
        return proxy.findAll();
    }
}
