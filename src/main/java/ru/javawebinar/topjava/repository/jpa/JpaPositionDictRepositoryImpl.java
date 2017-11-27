package ru.javawebinar.topjava.repository.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.PositionDict;
import ru.javawebinar.topjava.repository.PositionDictRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
@Repository
@Transactional(readOnly = true)
public class JpaPositionDictRepositoryImpl implements PositionDictRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PositionDict> getAll() {
        return em.createNamedQuery(PositionDict.GET_ALL, PositionDict.class)
                .getResultList();
    }
}
