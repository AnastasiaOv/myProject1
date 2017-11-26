package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Process;
import ru.javawebinar.topjava.repository.ProcessRepository;

import java.util.List;

/**
 * Created by Анастасия on 26.11.2017.
 */
public class DataJpaProcessRepositoryImpl implements ProcessRepository {

    @Autowired
    private ProxyProcessRepository proxy;

    @Autowired
    private ProxyUserRepository userProxy;

    @Autowired
    private ProxyPositionReposiory positionProxy;

    @Override
    public Process save(Process process) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Process get(int id) {
        return null;
    }

    @Override
    public List<Process> getAll(int userId) {
        return proxy.getAll(userId);
    }
}
