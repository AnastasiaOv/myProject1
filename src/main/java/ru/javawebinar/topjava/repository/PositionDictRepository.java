package ru.javawebinar.topjava.repository;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Position;
import ru.javawebinar.topjava.model.PositionDict;

import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
@Repository
public interface PositionDictRepository {
    List<PositionDict> getAll();

}
