package ru.mephi.qualityManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mephi.qualityManagement.model.Position;
import ru.mephi.qualityManagement.repository.PositionRepository;

import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
@Service("positionService")
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository repository;

    @Override
    public List<Position> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Position> getByProcessId(int processId) {
        return repository.getByProcessId(processId);
    }
}
