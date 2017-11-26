package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Rate;

import java.util.List;

/**
 * Created by Анастасия on 25.11.2017.
 */
@Transactional(readOnly = true)
public interface ProxyRateRepository extends JpaRepository<Rate, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Rate r WHERE r.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Rate save(Rate rate);

    @Override
    Rate findOne(Integer id);

    @Override
    List<Rate> findAll(Sort sort);

}
