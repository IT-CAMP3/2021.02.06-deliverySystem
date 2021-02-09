package pl.camp.it.delivery.system.serives.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.delivery.system.dao.IUserDAO;
import pl.camp.it.delivery.system.model.User;
import pl.camp.it.delivery.system.serives.IAuthenticationService;
import pl.camp.it.delivery.system.session.SessionObject;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    IUserDAO userDAO;

    @Resource
    SessionObject sessionObject;

    @Override
    public void authenticate(String login, String password) {
        Optional<User> optionalUser = this.userDAO.getUserByLogin(login);
        String userPass = optionalUser.orElseGet(User::new).getPass();
        String hashedPass = DigestUtils.md5Hex(password);
        if(userPass.equals(hashedPass)) {
            optionalUser.get().setPass(null);
            this.sessionObject.setUser(optionalUser.get());
        }
    }

    @Override
    public void logout() {
        this.sessionObject.setUser(null);
    }

    @Override
    public void changePassword(String login, String currentPass, String newPass) {
        this.sessionObject.setUser(null);
        authenticate(login, currentPass);

        if(!this.sessionObject.isLogged()) {
            return;
        }

        Optional<User> user = this.userDAO.getUserByLogin(login);
        user.get().setPass(DigestUtils.md5Hex(newPass));
        this.userDAO.persist(user.get());
    }
}
