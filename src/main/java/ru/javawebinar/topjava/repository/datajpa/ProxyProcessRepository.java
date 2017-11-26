package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Process;
import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
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
    Process save(Process process);

    @Override
    Process findOne(Integer id);

    @Override
    List<Process> findAll(Sort sort);


    @Query("SELECT p FROM Process p left join fetch all properties WHERE p.id=:id AND m.user.id=:userId")
    UserMeal get(@Param("id") int id, @Param("userId") int userId);

    @Query("SELECT p FROM Process p left join fetch all properties WHERE p.id=:id AND m.user.id=:userId ORDER BY m.start_time DESC")
    List<Process> getAll(@Param("userId") int userId);



    @Query("SELECT m from Process m WHERE m.user.id=:userId AND m.dateTime>=:after and m.dateTime<:before ORDER BY m.dateTime DESC")
    List<Process> getBetween(@Param("after") LocalDateTime startDate, @Param("before") LocalDateTime endDate, @Param("userId") int userId);

}
