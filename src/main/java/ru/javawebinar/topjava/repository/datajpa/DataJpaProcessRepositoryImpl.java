package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Process;
import ru.javawebinar.topjava.repository.ProcessRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
@Repository
public class DataJpaProcessRepositoryImpl implements ProcessRepository {
    @Autowired
    private ProxyProcessRepository proxy;

    @Autowired
    private ProxyUserRepository userProxy;


    @Override
    public Process save(Process process, int userId) {
        if (!process.isNew() && get(process.getId(), userId) == null) {
            return null;
        }
        return proxy.save(process);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }

    @Override
    public Process get(int id, int userId) {
        return null;
    }

    @Override
    public List<Process> getAll() {
        return proxy.getAll();
    }

    @Override
    public List<Process> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return null;
    }
}
