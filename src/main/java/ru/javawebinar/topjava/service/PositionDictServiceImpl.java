package ru.javawebinar.topjava.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.PositionDict;
import ru.javawebinar.topjava.repository.PositionDictRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
@Service("positionDictService")
public class PositionDictServiceImpl implements PositionDictService {
    @Autowired
    private PositionDictRepository repository;

    @Override
    public List<PositionDict> getAll() {
        return repository.getAll();
    }

    @Override
    public List<String> getAllPositionNames() {
        List<String> allPositions = new ArrayList<>();
        for (PositionDict position : repository.getAll())
            allPositions.add(position.getName());
        return allPositions;
    }

    @Override
    public List<PositionDict> getPositionsByName(List<String> positionNames) {
        List<PositionDict> result = new ArrayList<>();
        for (PositionDict position : repository.getAll()) {
            for (String name : positionNames) {
                if (position.getName().equals(name)) {
                    result.add(position);
                    break;
                }
            }
        }
        return result;
    }

}
