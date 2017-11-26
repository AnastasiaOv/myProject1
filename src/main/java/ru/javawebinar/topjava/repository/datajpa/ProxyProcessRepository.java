package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Process;

import java.util.List;

/**
 * Created by Анастасия on 26.11.2017.
 */
public interface ProxyProcessRepository extends  JpaRepository<Process, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Process p WHERE p.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Process save(Process rate);

    @Override
    Process findOne(Integer id);

    @Override
    List<Process> findAll(Sort sort);
}
