package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Position;
import ru.javawebinar.topjava.repository.PositionRepository;

import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository repository;

    @Override
    public List<Position> getAll() {
        return repository.getAll();
    }
}
