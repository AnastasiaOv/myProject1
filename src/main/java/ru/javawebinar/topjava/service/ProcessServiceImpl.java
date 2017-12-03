package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.javawebinar.topjava.model.Process;
import ru.javawebinar.topjava.repository.ProcessRepository;
import ru.javawebinar.topjava.util.exception.ExceptionUtil;

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
        return repository.save(process);
    }

    @Override
    public Process get(int id) {
        return repository.get(id);
    }

    @Override
    public Process update(Process process, int userId) {
        return ExceptionUtil.check(repository.save(process), process.getId());
    }

    @Override
    public void delete(int id) {
        ExceptionUtil.check(repository.delete(id), id);
    }

    @Override
    public List<Process> getAll(int userId) {
        return repository.getAll();
    }

    @Override
    public List<Process> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return repository.getBetween(startDate, StringUtils.isEmpty(endDate) ? LocalDateTime.now() : endDate, userId);
    }
}
