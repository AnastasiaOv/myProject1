package ru.mephi.qualityManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mephi.qualityManagement.model.TargetCriteria;
import ru.mephi.qualityManagement.repository.TargetCriteriaRepository;
import ru.mephi.qualityManagement.util.exception.ExceptionUtil;
import ru.mephi.qualityManagement.util.exception.NotFoundException;

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
