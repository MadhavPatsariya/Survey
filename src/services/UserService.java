package services;

import components.User;
import convertor.RoleConverter;

import java.util.HashMap;

public class UserService {
    HashMap<String, User> userList = new HashMap<>();

    public User addUser(String name, String role) {
        User user = new User(name, RoleConverter.converter(role));
        userList.put(name, user);
        return user;
    }

    public User getUserByName(String name) {
        return userList.get(name);
    }
}
