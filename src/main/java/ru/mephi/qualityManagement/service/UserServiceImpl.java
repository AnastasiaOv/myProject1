package ru.mephi.qualityManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mephi.qualityManagement.LoggedUser;
import ru.mephi.qualityManagement.model.PositionDict;
import ru.mephi.qualityManagement.model.User;
import ru.mephi.qualityManagement.repository.PositionDictRepository;
import ru.mephi.qualityManagement.repository.UserRepository;
import ru.mephi.qualityManagement.to.UserTo;
import ru.mephi.qualityManagement.util.UserUtil;
import ru.mephi.qualityManagement.util.exception.ExceptionUtil;
import ru.mephi.qualityManagement.util.exception.NotFoundException;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PositionDictRepository positionDictRepository;

    @CacheEvict(value = "users", allEntries = true)
    public User save(User user) {
        return repository.save(user);
    }

    @CacheEvict(value = "users", allEntries = true)
    public void delete(int id) {
        ExceptionUtil.check(repository.delete(id), id);
    }

    public User get(int id) throws NotFoundException {
        return ExceptionUtil.check(repository.get(id), id);
    }

    public User getByEmail(String email) throws NotFoundException {
        return ExceptionUtil.check(repository.getByEmail(email), "email=" + email);
    }

    @Cacheable("users")
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    @CacheEvict(value = "users", allEntries = true)
    @Transactional
    public void update(User user) throws NotFoundException {
        User oldUser = get(user.getId());
        UserUtil.update(oldUser, user);
        ExceptionUtil.check(repository.save(oldUser), user.getId());
    }

    @Override
    @CacheEvict(value = "users", allEntries = true)
    @Transactional
    public void update(UserTo user) throws NotFoundException {
        User oldUser = get(user.getId());
        UserUtil.updateFromTo(oldUser, user);
        ExceptionUtil.check(repository.save(oldUser), user.getId());
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void evictCache() {
    }

    @Override
    public List<PositionDict> getAllPositions() {
        return positionDictRepository.getAll();
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void enable(int id, boolean enable) {
        repository.enable(id, enable);
    }

    @Override
    public LoggedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = repository.getByEmail(email);
        if (u == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new LoggedUser(u);
    }

}
