package pl.camp.it.delivery.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.delivery.system.model.User;
import pl.camp.it.delivery.system.model.view.LoginObject;
import pl.camp.it.delivery.system.model.view.NewUser;
import pl.camp.it.delivery.system.serives.IUserService;
import java.util.List;

@Controller
@RequestMapping(value = "/supervisor")
public class SupervisorController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {
        return "supervisor/main";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUserForm(Model model) {
        model.addAttribute("newUser", new NewUser());
        return "supervisor/addUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute NewUser newUser, Model model) {
        LoginObject loginData = this.userService.addNewUser(newUser);
        model.addAttribute("login", loginData.getLogin());
        model.addAttribute("pass", loginData.getPassword());
        return "supervisor/addUserReport";
    }

    @RequestMapping(value = "/usersList", method = RequestMethod.GET)
    public String usersList(Model model) {
        List<User> userList = this.userService.getAllUsers();
        model.addAttribute("userList", userList);

        return "supervisor/userList";
    }
}
