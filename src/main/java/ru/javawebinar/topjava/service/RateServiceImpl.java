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
    public Rate save(Rate rate) {
        return repository.save(rate);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        ExceptionUtil.check(repository.delete(id), id);
    }

    @Override
    public Rate get(int id) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id), id);
    }

    @Override
    public List<Rate> getByUserAndPosition(int userId, List<PositionDict> positions) throws NotFoundException {
        List<Rate> allRates = repository.getAll();
        List<Rate> result = new ArrayList<>();
        for (Rate rate : allRates) {
            for (PositionDict position : positions)
                if (rate.getPositionId().equals(position.getId()) && rate.getUserId() == userId){
                    result.add(rate);
                    repository.save(rate);
                }
        }
        return result;
    }

    @Override
    public List<Rate> getAll() {
        return repository.getAll();
    }

    @Override
    @CacheEvict(value = "users", allEntries = true)
    @Transactional
    public void update(Rate rate) throws NotFoundException {
        Rate oldRate = get(rate.getId());
        oldRate.setPositionId(rate.getPositionId());
        oldRate.setRateAmount(rate.getRateAmount());
        ExceptionUtil.check(repository.save(oldRate), rate.getId());
    }

    @Override
    public void enable(int id, boolean enable) {

    }
}
