package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Process;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */

public interface ProcessRepository {
    // UserMeal.user = null
    Process save(Process process);

    // false if not found
    boolean delete(int id);

    // null if not found
    Process get(int id);

    // ORDERED DATE, TIME
    List<Process> getAll();

    List<Process> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId);

}
