package pl.camp.it.delivery.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.delivery.system.model.view.ChangePassObject;
import pl.camp.it.delivery.system.model.view.LoginObject;
import pl.camp.it.delivery.system.serives.IAuthenticationService;
import pl.camp.it.delivery.system.session.SessionObject;
import pl.camp.it.delivery.system.validators.PasswordValidator;

import javax.annotation.Resource;

@Controller
public class AuthenticationController {

    @Autowired
    IAuthenticationService authenticationService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("loginObject", new LoginObject());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute LoginObject loginObject) {
        boolean validationResult = PasswordValidator.validate(loginObject.getPassword());

        if(!validationResult)
            return "redirect:/login";

        this.authenticationService.authenticate(loginObject.getLogin(), loginObject.getPassword());

        if(this.sessionObject.isLogged()) {
            switch (this.sessionObject.getUser().getRole()) {
                case SUPERVISOR:
                    return "redirect:/supervisor/main";
                case STOREKEEPER:
                    //TODO
                    return "redirect:/storekeeper/main";
                case COURIER:
                    //TODO
                    return "redirect:/login";
                default:
                    return "redirect:/login";
            }
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        this.authenticationService.logout();
        return "redirect:/login";
    }

    @RequestMapping(value = "/changePass", method = RequestMethod.GET)
    public String changePassForm(Model model) {
        model.addAttribute("changePass", new ChangePassObject());
        model.addAttribute("user", this.sessionObject.getUser());
        return "changePass";
    }

    @RequestMapping(value = "/changePass", method = RequestMethod.POST)
    public String changePass(@ModelAttribute ChangePassObject changePassObject) {
        boolean validationResult = PasswordValidator.validate(changePassObject.getCurrentPass()) &&
                PasswordValidator.validate(changePassObject.getNewPass()) &&
                changePassObject.getNewPass().equals(changePassObject.getRepeatedNewPass());

        if(!validationResult) {
            return "redirect:/changePass";
        }

        this.authenticationService.changePassword(
                this.sessionObject.getUser().getLogin(),
                changePassObject.getCurrentPass(),
                changePassObject.getNewPass());

        if(!this.sessionObject.isLogged()) {
            return "redirect:/login";
        }

        switch (this.sessionObject.getUser().getRole()) {
            case SUPERVISOR:
                return "redirect:/supervisor/main";
            case COURIER:
                //TODO
                return "";
            case STOREKEEPER:
                return "redirect:/storekeeper/main";
            default:
                return "redirect:/logout";
        }
    }
}
