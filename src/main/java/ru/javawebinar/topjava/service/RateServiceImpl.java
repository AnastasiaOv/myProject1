package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.PositionDict;
import ru.javawebinar.topjava.model.Rate;
import ru.javawebinar.topjava.repository.RateRepository;
import ru.javawebinar.topjava.util.exception.ExceptionUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анастасия on 24.11.2017.
 */
@Service
public class RateServiceImpl implements RateService {
    @Autowired
    private RateRepository repository;

    @Override
    public Rate save(Rate rate, int userId) {
        return repository.save(rate, userId);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        ExceptionUtil.check(repository.delete(id), id);
    }

    @Override
    public Rate get(int id, int userId) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id,userId ), id);
    }

    @Override
    public List<Rate> getByUserId(int userId) throws NotFoundException {
        return repository.getByUserId(userId);
    }

    @Override
    public List<Rate> getByPositionName(List<PositionDict> positions) throws NotFoundException {
        List<Rate> result = new ArrayList<>();
        for (PositionDict position : positions) {
            Rate rate = new Rate(position.getId(), new BigDecimal(1));
            result.add(rate);
        }
        return result;
    }

    @Override
    public Rate update(Rate rate, int userId) {
        return ExceptionUtil.check(repository.save(rate, userId), rate.getId());
    }

    @Override
    public List<Rate> getAll() {
        return repository.getAll();
    }

    @Override
    @CacheEvict(value = "users", allEntries = true)
    @Transactional
    public Rate createOrUpdate(Rate rate, int userId) throws NotFoundException {
        if (rate.getId() == null || rate.getId() == 0) {
            repository.save(new Rate(rate.getPositionId(), rate.getRateAmount()), userId);
            return new Rate(rate.getPositionId(), rate.getRateAmount());
        } else {
            Rate oldRate = repository.get(rate.getId(), rate.getUser().getId());
            oldRate.setPositionId(rate.getPositionId());
            oldRate.setRateAmount(rate.getRateAmount());
            repository.save(oldRate, oldRate.getUser().getId());
            return oldRate;
        }
    }

}
