package ru.mephi.qualityManagement.service;


import ru.mephi.qualityManagement.model.PositionDict;
import ru.mephi.qualityManagement.model.User;
import ru.mephi.qualityManagement.to.UserTo;
import ru.mephi.qualityManagement.util.exception.NotFoundException;

import java.util.List;

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
