package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.javawebinar.topjava.model.Criteria;
import ru.javawebinar.topjava.model.Process;
import ru.javawebinar.topjava.repository.CriteriaRepository;
import ru.javawebinar.topjava.repository.ProcessRepository;
import ru.javawebinar.topjava.repository.RateRepository;
import ru.javawebinar.topjava.to.RateTo;
import ru.javawebinar.topjava.util.exception.ExceptionUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    private ProcessRepository repository;

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private CriteriaRepository criteriaRepository;

    @Override
    public Process save(Process process) {
        return ExceptionUtil.check(repository.save(process), process.getId());
    }

    @Override
    public Process get(int id) {
        Process process = repository.get(id);
        process.setRatesList(rateRepository.getAllRatesForProcess(id));

        return process;
    }

    @Override
    public Process update(Process process) {
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

    @Override
    public List<RateTo> getAllPositions() {
        List<RateTo> result = new ArrayList<>();
        for (Process process : repository.getAll()) {
            result.addAll(rateRepository.getAllRatesForProcess(process.getId()));
        }
        return result;
    }

    @Override
    public List<Criteria> getAllCriteria(int processId) {
        List<Criteria> result = criteriaRepository.getByProcessId(processId);
        return result;
    }
}
