package pl.camp.it.delivery.system.model.view;

public class LoginObject {
    private String login;
    private String password;

    public LoginObject() {
    }

    public LoginObject(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
