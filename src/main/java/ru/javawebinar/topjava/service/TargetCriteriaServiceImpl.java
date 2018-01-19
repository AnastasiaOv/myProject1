package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.TargetCriteria;
import ru.javawebinar.topjava.repository.TargetCriteriaRepository;
import ru.javawebinar.topjava.util.exception.ExceptionUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Анастасия on 18.01.2018.
 */
@Service
public class TargetCriteriaServiceImpl implements TargetCriteriaService {
    @Autowired
    private TargetCriteriaRepository targetCriteriaRepository;

    @Override
    public List<TargetCriteria> getCriteriaByProcess(int processId) {
        return null;
    }

    @Override
    public List<TargetCriteria> getAll() {
        return targetCriteriaRepository.getAll();
    }

    @Override
    public void delete(int id) throws NotFoundException {
        ExceptionUtil.check(targetCriteriaRepository.delete(id), id);
    }

    @Override
    public TargetCriteria get(int id) {
        return targetCriteriaRepository.get(id);
    }
}
