package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Position;

import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
public interface PositionRepository {
    List<Position> getAll();

    List<Position> getByProcessId(int processId);
}
