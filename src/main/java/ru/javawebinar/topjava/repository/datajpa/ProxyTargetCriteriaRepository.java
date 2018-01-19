package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.TargetCriteria;

import java.util.List;

/**
 * Created by Анастасия on 18.01.2018.
 */
@Transactional(readOnly = true)
public interface ProxyTargetCriteriaRepository extends JpaRepository<TargetCriteria, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM TargetCriteria r WHERE r.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT r FROM TargetCriteria r WHERE r.id=:id")
    TargetCriteria get(@Param("id") int id);

    @Override
    @Transactional
    TargetCriteria save(TargetCriteria targetCriteria);

    @Override
    TargetCriteria findOne(Integer id);

    @Override
    List<TargetCriteria> findAll(Sort sort);
}
