package pl.camp.it.delivery.system.rest.controllers;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.camp.it.delivery.system.model.User;
import pl.camp.it.delivery.system.serives.IUserService;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminAPIController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/add-default-supervisor", method = RequestMethod.GET)
    public ResponseEntity addDefaultSupervisor() {
        User user = new User();
        user.setLogin("superAdmin");
        user.setPass(DigestUtils.md5Hex("superAdmin!1"));
        user.setRole(User.Role.SUPERVISOR);
        user.setName("Super");
        user.setSurname("Admin");

        this.userService.persist(user);

        return ResponseEntity.ok().build();
    }
}
