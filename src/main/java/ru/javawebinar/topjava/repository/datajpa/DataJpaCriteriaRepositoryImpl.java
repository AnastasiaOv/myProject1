package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Criteria;
import ru.javawebinar.topjava.repository.CriteriaRepository;

import java.util.List;

/**
 * Created by Анастасия on 04.12.2017.
 */
@Repository
public class DataJpaCriteriaRepositoryImpl implements CriteriaRepository {
    @Autowired
    private ProxyCriteriaRepository proxyCriteriaRepository;

    @Autowired
    private ProxyProcessRepository processProxy;

    @Override
    public Criteria save(Criteria criteria, int processId) {
        criteria.setProcess(processProxy.getOne(processId));
        if (!criteria.isNew() && get(criteria.getId(), processId) == null) {
            return null;
        }
        return proxyCriteriaRepository.save(criteria);
    }

    @Override
    public boolean delete(int id) {
        return proxyCriteriaRepository.delete(id) != 0;
    }

    @Override
    public Criteria get(int id, int processId) {
        return proxyCriteriaRepository.get(id, processId);
    }

    @Override
    public List<Criteria> getByProcessId(int processId) {
        return proxyCriteriaRepository.getByProcessId(processId);
    }

    @Override
    public List<Criteria> getAll() {
        return proxyCriteriaRepository.findAll();
    }
}
