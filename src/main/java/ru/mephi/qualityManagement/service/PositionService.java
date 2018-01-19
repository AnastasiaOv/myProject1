package ru.mephi.qualityManagement.service;

import org.springframework.stereotype.Service;
import ru.mephi.qualityManagement.model.Position;

import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
@Service
public interface PositionService {
    List<Position> getAll();

    List<Position> getByProcessId(int processId);
}
