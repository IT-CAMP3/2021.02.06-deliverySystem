package pl.camp.it.delivery.system.model.view;

import pl.camp.it.delivery.system.model.User;

public class NewUser {
    private String name;
    private String surname;
    private User.Role role;

    public NewUser() {
    }

    public NewUser(String name, String surname, User.Role role) {
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public User.Role getRole() {
        return role;
    }

    public void setRole(User.Role role) {
        this.role = role;
    }
}
