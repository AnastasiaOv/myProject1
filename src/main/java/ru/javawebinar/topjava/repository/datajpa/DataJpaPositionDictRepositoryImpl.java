package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Position;
import ru.javawebinar.topjava.model.PositionDict;
import ru.javawebinar.topjava.repository.PositionDictRepository;

import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
@Repository
public class DataJpaPositionDictRepositoryImpl implements PositionDictRepository{
    @Autowired
    ProxyDictPositionReposiory proxy;

    @Override
    public List<PositionDict> getAll() {
        return proxy.getAll();
    }
}
