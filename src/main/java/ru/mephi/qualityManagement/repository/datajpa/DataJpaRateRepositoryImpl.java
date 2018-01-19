package ru.mephi.qualityManagement.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mephi.qualityManagement.model.Position;
import ru.mephi.qualityManagement.model.PositionDict;
import ru.mephi.qualityManagement.model.Rate;
import ru.mephi.qualityManagement.model.User;
import ru.mephi.qualityManagement.repository.RateRepository;
import ru.mephi.qualityManagement.to.RateTo;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Анастасия on 29.11.2017.
 */
@Repository
public class DataJpaRateRepositoryImpl implements RateRepository {
    @Autowired
    private ProxyRateRepository proxy;

    @Autowired
    private ProxyUserRepository userProxy;

    @Autowired
    private ProxyDictPositionReposiory positionDictProxy;

    @Autowired
    private ProxyPositionRepository positionRepository;

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
    public Rate get(int id) {
        return proxy.findOne(id);
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

    @Override
    public List<RateTo> getAllRatesForProcess(int processId) {
        List<RateTo> result = new ArrayList<>();
        List<Rate> allRates = proxy.getAll();
        Map<Integer, User> rateToUserMapping = new HashMap<>();
        Map<Integer, String> rateToPositonNameMapping = new HashMap<>();
        List<User> users = userProxy.getAll();
        List<PositionDict> positions = positionDictProxy.getAll();
        for (Rate rate : allRates) {
            rateToUserMapping.put(rate.getId(), getUserByPositionId(rate, users));
        }
        for (Rate rate : allRates) {
            rateToPositonNameMapping.put(rate.getId(), getPositionNameByRate(rate, positions));
        }
        List<Position> positionsForProcess = positionRepository.getByProcessId(processId);
        for (Rate rate : allRates) {
            RateTo rateTo = new RateTo(getPositionNameByRate(rate, positions), getUserName(rateToUserMapping.get(rate.getId())), rate.getId(), false, false, false, BigDecimal.ONE, processId);
            for (Position position : positionsForProcess) {
                if (position.getRate().equals(rate)) {
                    if (rateTo.isExecutor() == Boolean.TRUE)
                        rateTo.setExecutor(Boolean.TRUE);
                    else rateTo.setExecutor(position.getExecutor());
                    if (rateTo.isOwner() == Boolean.TRUE)
                        rateTo.setOwner(Boolean.TRUE);
                    else rateTo.setOwner(position.getOwner());
                    if (rateTo.isResponsible() == Boolean.TRUE)
                        rateTo.setResponsible(Boolean.TRUE);
                    else rateTo.setResponsible(position.getResponsible());
                }
            }
            result.add(rateTo);
        }

        return result;
    }

    private User getUserByPositionId(Rate rate, List<User> users) {
        for (User user : users) {
            if (user.getRates().contains(rate))
                return user;
        }
        return null;
    }

    private String getUserName(User user) {
        return user.getSurname() + " " + user.getFirstName() + " " + user.getSecondName();
    }

    private String getPositionNameByRate(Rate rate, List<PositionDict> positions) {
        for (PositionDict positionDict : positions) {
            if (positionDict.getId().equals(rate.getPositionId())) {
                return positionDict.getName();
            }
        }
        return "";
    }
}
