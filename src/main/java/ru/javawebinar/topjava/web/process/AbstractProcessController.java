package ru.javawebinar.topjava.web.process;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.Process;
import ru.javawebinar.topjava.service.ProcessService;
import ru.javawebinar.topjava.web.ExceptionInfoHandler;
import ru.javawebinar.topjava.web.meal.AbstractMealController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
public class AbstractProcessController extends ExceptionInfoHandler {
    protected static final LoggerWrapper LOG = LoggerWrapper.get(AbstractMealController.class);

    @Autowired
    protected ProcessService service;

    public Process get(int id) {
        int userId = LoggedUser.id();
        LOG.info("get meal {} for User {}", id, userId);
        return service.get(id);
    }

    public void delete(int id) {
        int userId = LoggedUser.id();
        LOG.info("delete meal {} for User {}", id, userId);
        service.delete(id, userId);
    }

    public List<Process> getAll() {
        int userId = LoggedUser.id();
        LOG.info("getAll for User {}", userId);
        return service.getAll(userId);
    }

    public List<Process> getBetween(LocalDateTime startDate, LocalDateTime endDate) {
        int userId = LoggedUser.id();
        LOG.info("getBetween {} and {} for User {}", startDate, endDate, userId);
        return service.getBetween(startDate, endDate, userId);
    }

    public void deleteAll() {
        int userId = LoggedUser.id();
        LOG.info("deleteAll for User {}", userId);
        service.deleteAll(userId);
    }

    public void update(Process process, int id) {
        process.setId(id);
        int userId = LoggedUser.id();
        LOG.info("update {} for User {}", process, userId);
        service.update(process, userId);
    }

    public Process create(Process process) {
        process.setId(null);
        int userId = LoggedUser.id();
        LOG.info("create {} for User {}" + process, userId);
        return service.save(process, userId);
    }
}

