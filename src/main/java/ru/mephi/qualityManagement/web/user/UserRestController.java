package ru.mephi.qualityManagement.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.mephi.qualityManagement.LoggedUser;
import ru.mephi.qualityManagement.LoggerWrapper;
import ru.mephi.qualityManagement.model.User;
import ru.mephi.qualityManagement.service.UserService;

@Controller
public class UserRestController {
    private static final LoggerWrapper LOG = LoggerWrapper.get(UserRestController.class);

    @Autowired
    private UserService service;

    public User get() {
        int id = LoggedUser.id();
        LOG.info("get", id);
        return service.get(id);
    }

    public void delete() {
        int id = LoggedUser.id();
        LOG.info("delete {}", id);
        service.delete(id);
    }

    public void update(User user) {
        int id = LoggedUser.id();
        LOG.info("update");
        service.update(user);
    }
}
