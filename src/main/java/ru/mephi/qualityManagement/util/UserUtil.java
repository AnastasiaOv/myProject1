package ru.mephi.qualityManagement.util;

import ru.mephi.qualityManagement.model.User;
import ru.mephi.qualityManagement.to.UserTo;

public class UserUtil {

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
        return oldUser;
    }
}
