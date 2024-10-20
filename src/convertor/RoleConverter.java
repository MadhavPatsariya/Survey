package convertor;

import enumerations.Role;

public class RoleConverter {

    public static Role converter(String role) {
        return switch (role) {
           case "user" -> Role.USER;
           case "admin" -> Role.ADMIN;
           default -> Role.NONE;
        };
    }
}
