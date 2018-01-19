package ru.mephi.qualityManagement.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mephi.qualityManagement.model.TargetCriteria;
import ru.mephi.qualityManagement.repository.TargetCriteriaRepository;

import java.util.List;

/**
 * Created by Анастасия on 18.01.2018.
 */
@Repository
public class DataJpaTargetCriteriaRepositoryImpl implements TargetCriteriaRepository {
    @Autowired
    private ProxyTargetCriteriaRepository proxyTargetCriteriaRepository;

    @Autowired
    private ProxyProcessRepository processProxy;

    @Override
    public TargetCriteria save(TargetCriteria criteria, int processId) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return proxyTargetCriteriaRepository.delete(id) != 0;
    }

    @Override
    public TargetCriteria get(int id) {
        return proxyTargetCriteriaRepository.get(id);
    }

    @Override
    public List<TargetCriteria> getAll() {
        return proxyTargetCriteriaRepository.findAll();
    }
}
