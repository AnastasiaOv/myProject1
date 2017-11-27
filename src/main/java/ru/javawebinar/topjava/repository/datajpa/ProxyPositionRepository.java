package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Position;

import java.util.List;

/**
 * Created by Анастасия on 27.11.2017.
 */
@Repository
public interface ProxyPositionRepository extends JpaRepository<Position, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Position p WHERE p.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Position save(Position position);

    @Override
    Position findOne(Integer id);

    @Override
    List<Position> findAll(Sort sort);

    @Query("SELECT p FROM PositionDict p")
    List<Position> getAll();

}
