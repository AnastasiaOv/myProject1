package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Process;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.ProcessRepository;
import ru.javawebinar.topjava.repository.UserMealRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    private ProcessRepository repository;

    @Override
    public Process save(Process process, int userId) {
        return null;
    }

    @Override
    public Process update(Process process, int userId) {
        return null;
    }

    @Override
    public void delete(int id, int userId) {

    }

    @Override
    public void deleteAll(int userId) {

    }

    @Override
    public Process get(int id, int userId) {
        return null;
    }

    @Override
    public List<Process> getAll(int userId) {
        return repository.getAll();
    }

    @Override
    public List<Process> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return null;
    }
}
