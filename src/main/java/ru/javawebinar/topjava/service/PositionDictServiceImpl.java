package ru.javawebinar.topjava.service;


import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.PositionDict;
import ru.javawebinar.topjava.repository.PositionDictRepository;

import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
public class PositionDictServiceImpl implements PositionDictService {
    @Autowired
    private PositionDictRepository repository;

    @Override
    public List<PositionDict> getAll() {
        return repository.getAll();
    }
}
