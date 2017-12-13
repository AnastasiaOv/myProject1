package ru.javawebinar.topjava.service;


import ru.javawebinar.topjava.model.Process;
import ru.javawebinar.topjava.to.RateTo;

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

    List<Process> getAll(int userId);

    List<Process> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId);

    List<RateTo> getAllPositions();
}
