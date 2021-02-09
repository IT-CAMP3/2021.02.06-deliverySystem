package pl.camp.it.delivery.system.dao;

import pl.camp.it.delivery.system.model.User;
import java.util.List;

import java.util.Optional;

public interface IUserDAO {
    Optional<User> getUserByLogin(String login);
    void persist(User user);
    List<User> getAllUsers();
}
