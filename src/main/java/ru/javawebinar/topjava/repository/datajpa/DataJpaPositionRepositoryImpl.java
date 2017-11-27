package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Position;
import ru.javawebinar.topjava.repository.PositionRepository;

import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
public class DataJpaPositionRepositoryImpl implements PositionRepository{
    @Autowired
    ProxyPositionRepository proxy;

    @Override
    public List<Position> getAll() {
        return proxy.getAll();
    }
}
