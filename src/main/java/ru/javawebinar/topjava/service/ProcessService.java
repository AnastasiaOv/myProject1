package ru.javawebinar.topjava.service;


import ru.javawebinar.topjava.model.Process;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
public interface ProcessService {

    public Process save(Process process, int userId);

    public Process update(Process process, int userId);

    public void delete(int id, int userId);

    public void deleteAll(int userId);

    public Process get(int id, int userId);

    public List<Process> getAll(int userId);

    public List<Process> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId);
}
