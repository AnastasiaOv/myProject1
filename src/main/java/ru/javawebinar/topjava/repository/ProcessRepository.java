package ru.javawebinar.topjava.repository;

import java.util.List;
import ru.javawebinar.topjava.model.Process;

/**
 * Created by Анастасия on 26.11.2017.
 */
public interface ProcessRepository {
    Process save(Process process);

    // false if not found
    boolean delete(int id);

    // null if not found
    Process get(int id);

    List<Process> getAll(int userId);

}
