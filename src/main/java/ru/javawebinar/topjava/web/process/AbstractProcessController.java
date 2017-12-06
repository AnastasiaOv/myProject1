package ru.javawebinar.topjava.web.process;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.Process;
import ru.javawebinar.topjava.service.CriteriaService;
import ru.javawebinar.topjava.service.PositionService;
import ru.javawebinar.topjava.service.ProcessService;
import ru.javawebinar.topjava.web.ExceptionInfoHandler;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
public class AbstractProcessController extends ExceptionInfoHandler {
    protected static final LoggerWrapper LOG = LoggerWrapper.get(AbstractProcessController.class);

    @Autowired
    protected ProcessService service;

    @Autowired
    protected CriteriaService criteriaService;

    @Autowired
    PositionService positionService;

    public Process get(int id) {
        int userId = LoggedUser.id();
        LOG.info("get meal {} for Process {}", id, userId);
        return service.get(id);
    }

    public void delete(int id) {
        LOG.info("delete Process {} ", id);
        service.delete(id);
    }

    public List<Process> getAll() {
        int userId = LoggedUser.id();
        LOG.info("getAll for Process {}", userId);
        return service.getAll(userId);
    }

    public List<Process> getBetween(LocalDateTime startDate, LocalDateTime endDate) {
        int userId = LoggedUser.id();
        LOG.info("getBetween {} and {} for Process {}", startDate, endDate, userId);
        return service.getBetween(startDate, endDate, userId);
    }

    public void update(Process process, int id) {
        process.setId(id);
        process.setCriteriaList(criteriaService.getCriteriaByProcess(process.getId()));
        process.setPositionList(positionService.getByProcessId(process.getId()));
        int userId = LoggedUser.id();
        LOG.info("update {} for Process {}", process, userId);
        service.update(process);
    }

    public Process create(Process process) {
        process.setId(null);
        LOG.info("create Process {}" + process);
        return service.save(process);
    }
}

