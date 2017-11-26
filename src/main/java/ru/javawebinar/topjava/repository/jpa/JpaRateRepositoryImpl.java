package ru.javawebinar.topjava.repository.jpa;

import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Rate;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.RateRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Анастасия on 24.11.2017.
 */
public class JpaRateRepositoryImpl implements RateRepository {
    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public Rate save(Rate rate) {
        if (rate.isNew()) {
            em.persist(rate);
        } else {
            em.merge(rate);
        }
        return rate;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(Rate.DELETE).setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public Rate get(int id) {
        return null;
    }

    @Override
    public Rate getByUser(User user) {
        return null;
    }

    @Override
    public List<Rate> getAll() {
        return null;
    }
}
