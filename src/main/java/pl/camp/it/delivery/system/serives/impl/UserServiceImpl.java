package pl.camp.it.delivery.system.serives.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.delivery.system.dao.IUserDAO;
import pl.camp.it.delivery.system.model.User;
import pl.camp.it.delivery.system.model.view.LoginObject;
import pl.camp.it.delivery.system.model.view.NewUser;
import pl.camp.it.delivery.system.serives.IUserService;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDAO userDAO;

    @Override
    public void persist(User user) {
        this.userDAO.persist(user);
    }

    @Override
    public LoginObject addNewUser(NewUser newUser) {
        User user = new User();
        user.setName(newUser.getName());
        user.setSurname(newUser.getSurname());
        user.setRole(newUser.getRole());
        user.setLogin(newUser.getName().toLowerCase()+"."+newUser.getSurname().toLowerCase());

        String generatedPass = generatePass();
        System.out.println(generatedPass);
        String hashedPass = DigestUtils.md5Hex(generatedPass);
        System.out.println(hashedPass);

        user.setPass(hashedPass);

        this.userDAO.persist(user);

        return new LoginObject(user.getLogin(), generatedPass);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userDAO.getAllUsers();
    }

    private String generatePass() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers)+"A!1";
    }
}
