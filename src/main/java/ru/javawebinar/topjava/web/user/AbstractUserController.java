package ru.javawebinar.topjava.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Rate;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.PositionDictService;
import ru.javawebinar.topjava.service.RateService;
import ru.javawebinar.topjava.service.UserService;
import ru.javawebinar.topjava.to.UserTo;
import ru.javawebinar.topjava.util.UserUtil;
import ru.javawebinar.topjava.web.ExceptionInfoHandler;

import java.util.List;

/**
 * User: gkislin
 */
public abstract class AbstractUserController extends ExceptionInfoHandler {
    @Autowired
    private UserService service;

    @Autowired
    private PositionDictService positionDictService;

    @Autowired
    private RateService rateService;

    public List<User> getAll() {
        LOG.info("getAll");
        List<User> all = service.getAll();
        all.forEach(u -> u.setPassword(null));
        return all;
    }

    public User get(int id) {
        LOG.info("get " + id);
        User user = service.get(id);
        user.setPassword(null);
        return user;
    }

    public User create(UserTo userTo) {
        LOG.info("create " + userTo);
        return create(UserUtil.createFromTo(userTo));
    }

    public User create(User user) {
        LOG.info("create " + user);
        user.setId(null);
        user.setPositions(positionDictService.getPositionsByName(user.getPositionNames()));
        List<Rate> rates = rateService.getByPositionName(user.getPositions());
        for(Rate rate:rates){
            rate.setUser(user);
        }
        user.setRates(rates);
        return service.save(UserUtil.encode(user));
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        service.delete(id);
    }

    public void update(UserTo userTo, int id) {
        LOG.info("update " + userTo);
        userTo.setId(id);
        service.update(userTo);
    }

    public void update(User user, int id) {
        LOG.info("update " + user);
        user.setId(id);
        List<Rate> oldRates = rateService.getByUserId(id);
        for(Rate oldRate: oldRates){
            rateService.delete(oldRate.getId());
        }
        user.setPositions(positionDictService.getPositionsByName(user.getPositionNames()));
        List<Rate> rates = rateService.getByPositionName(user.getPositions());
        for(Rate rate:rates){
            rate.setUser(user);
            rateService.save(rate, user.getId());
        }
        user.setRates(rates);
        service.update(user);
    }

    public User getByMail(String email) {
        LOG.info("getByEmail " + email);
        return service.getByEmail(email);
    }

    public void enable(int id, boolean enable) {
        LOG.info("enable " + id);
        service.enable(id, enable);
    }
}
