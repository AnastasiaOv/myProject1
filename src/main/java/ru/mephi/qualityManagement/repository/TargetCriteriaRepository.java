package ru.mephi.qualityManagement.repository;

import ru.mephi.qualityManagement.model.TargetCriteria;

import java.util.List;

/**
 * Created by Анастасия on 18.01.2018.
 */
public interface TargetCriteriaRepository {
    TargetCriteria save(TargetCriteria criteria, int processId);

    // false if not found
    boolean delete(int id);

    // null if not found
    TargetCriteria get(int id);

    List<TargetCriteria> getAll();
}
