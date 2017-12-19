package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Criteria;

import java.util.List;

/**
 * Created by Анастасия on 04.12.2017.
 */
@Service
public interface CriteriaService {

    List<Criteria> getCriteriaByProcess(int processId);

    List<Criteria> getAll();
}
