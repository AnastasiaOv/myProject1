package ru.mephi.qualityManagement.web.process;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mephi.qualityManagement.LoggedUser;
import ru.mephi.qualityManagement.LoggerWrapper;
import ru.mephi.qualityManagement.model.Process;
import ru.mephi.qualityManagement.service.CriteriaService;
import ru.mephi.qualityManagement.service.PositionService;
import ru.mephi.qualityManagement.service.ProcessService;
import ru.mephi.qualityManagement.web.ExceptionInfoHandler;

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
        return service.getAll();
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

