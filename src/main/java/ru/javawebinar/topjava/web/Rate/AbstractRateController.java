package ru.javawebinar.topjava.web.Rate;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.Rate;
import ru.javawebinar.topjava.service.RateService;
import ru.javawebinar.topjava.web.ExceptionInfoHandler;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Анастасия on 29.11.2017.
 */
public class AbstractRateController extends ExceptionInfoHandler {
    protected static final LoggerWrapper LOG = LoggerWrapper.get(AbstractRateController.class);

    @Autowired
    protected RateService service;

    public Rate get(int id) {
        int userId = LoggedUser.id();
        LOG.info("get meal {} for User {}", id, userId);
        return service.get(id, userId);
    }

    public void delete(int id) {
        LOG.info("delete meal {} for User {}", id);
        service.delete(id);
    }

    public List<Rate> getAll() {
        int userId = LoggedUser.id();
        LOG.info("getAll for User {}", userId);
        return service.getAll();
    }


    public void update(Rate rate, int id) {
        rate.setId(id);
        int userId = LoggedUser.id();
        LOG.info("update {} for User {}", rate, userId);
        service.update(rate, userId);
    }

    public Rate create(Rate rate) {
        rate.setId(null);
        int userId = LoggedUser.id();
        LOG.info("create {} for User {}" + rate, userId);
        return service.save(rate, userId);
    }
}
