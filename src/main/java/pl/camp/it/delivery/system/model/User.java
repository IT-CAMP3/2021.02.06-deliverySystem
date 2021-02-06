package pl.camp.it.delivery.system.model;

public class User {
    private int id;
    private String login;
    private String pass;
    private String name;
    private String surname;
    private ROLE role;

    public User() {
    }

    public User(int id, String login, String pass, String name, String surname, ROLE role) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public enum ROLE {
        STOREKEEPER,
        COURIER
    }
}
