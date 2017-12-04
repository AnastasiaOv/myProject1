package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Criteria;

import java.util.List;

/**
 * Created by Анастасия on 04.12.2017.
 */
@Transactional(readOnly = true)
public interface ProxyCriteriaRepository extends JpaRepository<Criteria, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Criteria r WHERE r.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT r FROM Criteria r WHERE r.id=:id AND r.process.id=:processId")
    Criteria get(@Param("id") int id, @Param("processId") int processId);

    @Query("SELECT r FROM Criteria r WHERE r.process.id=:processId")
    List<Criteria> getByProcessId(@Param("processId") int processId);

    @Override
    @Transactional
    Criteria save(Criteria rate);

    @Override
    Criteria findOne(Integer id);

    @Override
    List<Criteria> findAll(Sort sort);
}
