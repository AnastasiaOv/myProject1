package ru.mephi.qualityManagement.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.mephi.qualityManagement.model.User;

import java.util.List;

/**
 * GKislin
 * 27.03.2015.
 */
@Transactional(readOnly = true)
public interface ProxyUserRepository extends JpaRepository<User, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    User save(User user);

    @Override
    User findOne(Integer id);

    @Override
    List<User> findAll(Sort sort);

    User getByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.enabled=:enabled WHERE u.id=:id")
    void enable(@Param("id") int id, @Param("enabled") boolean enabled);

    @Query("Select u from User u")
    List<User> getAll();
}
