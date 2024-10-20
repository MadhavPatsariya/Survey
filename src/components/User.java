package components;

import enumerations.Role;

public class User {
    String name;
    Role role;

    public User(String name, Role role) {
        this.name = name;
        this.role = role;
    }
    //user can change name. Admin can change the role.
    public void setRole(Role role) {
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return name + " " + role.name();
    }
}
