package ru.mephi.qualityManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mephi.qualityManagement.model.Criteria;
import ru.mephi.qualityManagement.repository.CriteriaRepository;

import java.util.List;

/**
 * Created by Анастасия on 04.12.2017.
 */
@Service("criteriaService")
public class CriteriaServiceImpl implements CriteriaService{
    @Autowired
    private CriteriaRepository criteriaRepository;

    @Override
    public List<Criteria> getCriteriaByProcess(int processId) {
        return criteriaRepository.getByProcessId(processId);
    }

    @Override
    public List<Criteria> getAll() {
        return criteriaRepository.getAll();
    }
}
