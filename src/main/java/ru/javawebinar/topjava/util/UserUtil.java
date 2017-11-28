package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.to.UserTo;

/**
 * GKislin
 * 01.05.2015.
 */
public class UserUtil {

    public static User createFromTo(UserTo newUser) {
        if (newUser.getIsAdmin())
            return new User(null, newUser.getName(), newUser.getEmail().toLowerCase(), newUser.getSurname(), newUser.getFirstName(), newUser.getSecondName(),
                    PasswordUtil.encode(newUser.getPassword()), true, Role.ROLE_ADMIN, newUser.getRates());
        else
            return new User(null, newUser.getName(), newUser.getEmail().toLowerCase(), newUser.getSurname(), newUser.getFirstName(), newUser.getSecondName(),
                    PasswordUtil.encode(newUser.getPassword()), true, Role.ROLE_USER, newUser.getRates());
    }

    public static UserTo asTo(AbstractUser user) {
        return new UserTo(user.getId(), user.getName(), user.getEmail(), user.getSurname(), user.getFirstName(), user.getSecondName(), user.getCaloriesPerDay(), user.getIsAdmin(),  user.getPositionDicts(),user.getRates());
    }

    public static User updateFromTo(User oldUser, UserTo updatedUser) {
        return updateInternal(oldUser, updatedUser);
    }

    public static User update(User oldUser, User updatedUser) {
        oldUser.setRoles(updatedUser.getRoles());
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
        if (updatedUser.getIsAdmin()) {
            oldUser.setRoles(Role.ROLE_ADMIN);
        } else {
            oldUser.setRoles(Role.ROLE_USER);
        }
        return oldUser;
    }
}
