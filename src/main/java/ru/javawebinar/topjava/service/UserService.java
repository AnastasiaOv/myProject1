package ru.javawebinar.topjava.service;


import ru.javawebinar.topjava.model.PositionDict;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.to.UserTo;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

/**
 * Service interface for User
 *
 * User: gkislin
 * Date: 22.08.2014
 */
public interface UserService {

    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    List<User> getAll();

    void update(User user) throws NotFoundException;

    void update(UserTo user) throws NotFoundException;

    void evictCache();

    List<PositionDict> getAllPositions();

    void enable(int id, boolean enable);
}
