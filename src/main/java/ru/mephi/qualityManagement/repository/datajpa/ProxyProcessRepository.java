package ru.mephi.qualityManagement.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.mephi.qualityManagement.model.Process;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Анастасия on 26.11.2017.
 */
public interface ProxyProcessRepository extends JpaRepository<Process, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Process p WHERE p.id=:id")
    int delete(@Param("id") int id);

    @Override
    Process save(Process process);

    @Override
    Process findOne(Integer id);

    @Query("SELECT p FROM Process p WHERE p.id=:id")
    Process get(@Param("id") int id);

    @Query("SELECT p FROM Process p ORDER BY p.start_time DESC")
    List<Process> getAll();

    @Query("SELECT p from Process p WHERE p.start_time>=:after and p.start_time<:before ORDER BY p.start_time DESC")
    List<Process> getBetween(@Param("after") LocalDateTime startDate, @Param("before") LocalDateTime endDate);

}
