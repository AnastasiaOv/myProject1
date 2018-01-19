package ru.mephi.qualityManagement.service;


import ru.mephi.qualityManagement.model.Criteria;
import ru.mephi.qualityManagement.model.Process;
import ru.mephi.qualityManagement.to.RateTo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
public interface ProcessService {

    Process save(Process process);

    Process update(Process process);

    void delete(int id);

    Process get(int id);

    List<Process> getAll();

    List<Process> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId);

    List<RateTo> getAllPositions();

    List<Criteria> getAllCriteria(int processId);
}
