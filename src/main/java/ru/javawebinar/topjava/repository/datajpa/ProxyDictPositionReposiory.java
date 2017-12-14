package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Position;
import ru.javawebinar.topjava.model.PositionDict;

import java.util.List;

/**
 * Created by Анастасия on 26.11.2017.
 */
public interface ProxyDictPositionReposiory extends JpaRepository<PositionDict, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Position p WHERE p.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    PositionDict save(PositionDict position);

    @Override
    PositionDict findOne(Integer id);

    @Override
    List<PositionDict> findAll(Sort sort);

    @Query("SELECT p FROM PositionDict p")
    List<PositionDict> getAll();

    @Query("SELECT p FROM PositionDict p Where p.id = :id")
    PositionDict getById(@Param("id") int id);

}
