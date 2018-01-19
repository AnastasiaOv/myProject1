package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.TargetCriteria;
import ru.mephi.qualityManagement.util.exception.NotFoundException;

import java.util.List;

/**
 * Created by Анастасия on 18.01.2018.
 */

public interface TargetCriteriaService{
    List<TargetCriteria> getCriteriaByProcess(int processId);

    List<TargetCriteria> getAll();

    void delete(int id) throws NotFoundException;

    TargetCriteria get(int id);
}
