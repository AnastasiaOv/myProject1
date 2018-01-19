package ru.mephi.qualityManagement.repository;

import ru.mephi.qualityManagement.model.PositionDict;

import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
public interface PositionDictRepository {
    List<PositionDict> getAll();

    PositionDict getById(int positionId);

}
