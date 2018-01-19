package ru.mephi.qualityManagement.repository;

import ru.mephi.qualityManagement.model.Criteria;

import java.util.List;

/**
 * Created by Анастасия on 04.12.2017.
 */
public interface CriteriaRepository {
    Criteria save(Criteria criteria, int processId);

    // false if not found
    boolean delete(int id);

    // null if not found
    Criteria get(int id, int processId);

    // null if not found
    List<Criteria> getByProcessId(int processId);

    List<Criteria> getAll();
}
