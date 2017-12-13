package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Rate;
import ru.javawebinar.topjava.model.UserMeal;

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

    @Query("SELECT r FROM Rate r WHERE r.id=:id AND r.user.id=:userId")
    Rate get(@Param("id") int id, @Param("userId") int userId);

    @Query("SELECT r FROM Rate r WHERE r.user.id=:userId")
    List<Rate> getByUserId(@Param("userId") int userId);

    @Query("SELECT r FROM Rate r")
    List<Rate> getAll();

    @Override
    @Transactional
    Rate save(Rate rate);

    @Override
    Rate findOne(Integer id);

    @Override
    List<Rate> findAll(Sort sort);

}
