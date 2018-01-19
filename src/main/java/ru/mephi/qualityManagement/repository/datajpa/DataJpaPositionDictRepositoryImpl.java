package ru.mephi.qualityManagement.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mephi.qualityManagement.model.PositionDict;
import ru.mephi.qualityManagement.repository.PositionDictRepository;

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

    @Override
    public PositionDict getById(int positionId) {
        return proxy.getById(positionId);
    }
}
