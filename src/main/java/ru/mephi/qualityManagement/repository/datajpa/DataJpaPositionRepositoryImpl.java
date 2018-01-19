package ru.mephi.qualityManagement.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mephi.qualityManagement.model.Position;
import ru.mephi.qualityManagement.repository.PositionRepository;

import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
@Repository
public class DataJpaPositionRepositoryImpl implements PositionRepository {
    @Autowired
    ProxyPositionRepository proxy;

    @Override
    public List<Position> getAll() {
        return proxy.getAll();
    }

    @Override
    public List<Position> getByProcessId(int processId) {
        return proxy.getByProcessId(processId);
    }
}
