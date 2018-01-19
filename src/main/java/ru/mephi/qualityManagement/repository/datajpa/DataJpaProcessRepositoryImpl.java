package ru.mephi.qualityManagement.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mephi.qualityManagement.model.Process;
import ru.mephi.qualityManagement.repository.ProcessRepository;

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
    @Transactional
    public Process save(Process process) {
        if (!process.isNew() && process.getId() == null) {
            return null;
        }
        return proxy.save(process);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }

    @Override
    public Process get(int id) {
        return proxy.get(id);
    }

    @Override
    public List<Process> getAll() {
        return proxy.getAll();
    }

    @Override
    public List<Process> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return proxy.getBetween(startDate, endDate);
    }
}
