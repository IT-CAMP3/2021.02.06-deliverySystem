package pl.camp.it.delivery.system.serives;

public interface IAuthenticationService {
    void authenticate(String login, String password);
    void logout();
    void changePassword(String login, String currentPass, String newPass);
}
