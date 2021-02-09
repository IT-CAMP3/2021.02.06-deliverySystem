package pl.camp.it.delivery.system.serives;

import pl.camp.it.delivery.system.model.User;
import pl.camp.it.delivery.system.model.view.LoginObject;
import pl.camp.it.delivery.system.model.view.NewUser;
import java.util.List;

public interface IUserService {
    void persist(User user);
    LoginObject addNewUser(NewUser newUser);
    List<User> getAllUsers();
}
