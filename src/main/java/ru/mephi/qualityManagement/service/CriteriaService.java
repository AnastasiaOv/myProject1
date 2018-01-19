package ru.mephi.qualityManagement.service;

import org.springframework.stereotype.Service;
import ru.mephi.qualityManagement.model.Criteria;

import java.util.List;

/**
 * Created by Анастасия on 04.12.2017.
 */
@Service
public interface CriteriaService {

    List<Criteria> getCriteriaByProcess(int processId);

    List<Criteria> getAll();
}
