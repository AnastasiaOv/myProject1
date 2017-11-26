package ru.javawebinar.topjava.web.converter;

import ru.javawebinar.topjava.model.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SS on 26.11.2017.
 */
public class ReadableRoles {
    public static List<String> getReadableRoles() {
        List<String> readableRolesList = new ArrayList<>();
        for (Role role : Role.values()) {
            switch (role.toString()) {
                case "ROLE_USER" : readableRolesList.add("Пользователь");
                break;
                case "ROLE_ADMIN" : readableRolesList.add("Администратор");
                break;
            }
        }
        return readableRolesList;
    }
}
