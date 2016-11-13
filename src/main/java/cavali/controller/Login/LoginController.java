package cavali.controller.Login;

import cavali.entity.Rider.Rider;
import cavali.entity.User.User;
import cavali.service.Rider.RiderService;
import cavali.service.User.UserService;
import cavali.url.AppUrls;
import cavali.url.Login.LoginUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Ola on 04.11.2016.
 */
@Controller
public class LoginController {

    @Autowired
    RiderService riderService;

    @Autowired
    UserService userService;

    private String viewPath = "page/";

    @RequestMapping(value = LoginUrls.LOGIN, method = GET)
    public String loginPage(ModelMap model){
        model.addAttribute("rider", new Rider());
        model.addAttribute("user", new User());
        return this.viewPath + "login";
    }

    @RequestMapping(value = "/login/register", method = POST)
    @Transactional
    public String registerUser(@ModelAttribute Rider rider, @ModelAttribute User user){
        user.setRole("Admin");
        userService.create(user);
        rider.setUser(user);
        riderService.create(rider);
        return "redirect:" + LoginUrls.LOGIN;
    }
}
