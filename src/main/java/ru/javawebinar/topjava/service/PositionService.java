package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Position;

import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
@Service
public interface PositionService {
    List<Position> getAll();

    List<Position> getByProcessId(int processId);
}
