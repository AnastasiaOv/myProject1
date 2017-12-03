package ru.javawebinar.topjava.util;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.RateService;
import ru.javawebinar.topjava.to.UserTo;

/**
 * GKislin
 * 01.05.2015.
 */
public class UserUtil {

    @Autowired
    RateService rateService;

    public static User createFromTo(UserTo newUser) {
        return new User(null, newUser.getName(), newUser.getEmail().toLowerCase(), newUser.getSurname(), newUser.getFirstName(), newUser.getSecondName(),
                PasswordUtil.encode(newUser.getPassword()), true, newUser.getRoles(), newUser.getPositions(), newUser.getRates());
    }

    public static UserTo asTo(AbstractUser user) {
        return new UserTo(user.getId(),user.getName(),user.getEmail(), user.getSurname(), user.getFirstName(),user.getSecondName(),user.getCaloriesPerDay(),
                user.getRoles(),user.getRates(),user.getPositions());
    }

    public static User updateFromTo(User oldUser, UserTo updatedUser) {
        return updateInternal(oldUser, updatedUser);
    }

    public static User update(User oldUser, User updatedUser) {
        oldUser.setEnabled(updatedUser.isEnabled());
        return updateInternal(oldUser, updatedUser);
    }

    public static <T extends AbstractUser> T encode(T u) {
        u.setPassword(PasswordUtil.encode(u.getPassword()));
        return u;
    }

    private static User updateInternal(User oldUser, AbstractUser updatedUser) {
        String password = updatedUser.getPassword();
        if (password != null) {
            oldUser.setPassword(PasswordUtil.encode(password));
        }
        oldUser.setName(updatedUser.getName());
        oldUser.setEmail(updatedUser.getEmail().toLowerCase());
        oldUser.setCaloriesPerDay(updatedUser.getCaloriesPerDay());
        oldUser.setRoles(updatedUser.getRoles());
        oldUser.setPositions(updatedUser.getPositions());
        oldUser.setRates(updatedUser.getRates());
        return oldUser;
    }
}
