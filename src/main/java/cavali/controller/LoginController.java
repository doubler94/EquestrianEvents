package cavali.controller;

import cavali.entity.Rider.Rider;
import cavali.entity.User.User;
import cavali.service.Rider.RiderService;
import cavali.service.User.UserService;
import cavali.url.LoginUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Ola on 04.11.2016.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    RiderService riderService;

    @Autowired
    UserService userService;

    @RequestMapping(method = GET)
    public String login()
    {
        return "index";
    }

    private String viewPath = "page/";

    @RequestMapping(value = LoginUrls.LOGIN, method = GET)
    public String loginPage(HttpServletRequest request, HttpServletResponse response, Model model){
        model.addAttribute("rider", new Rider());
        return this.viewPath + "login";
    }

    @RequestMapping(value = "/login/register", method = POST)
    public String registerUser(@ModelAttribute Rider rider, BindingResult bindingResult, Model model){

        User user = new User();
        user.setLogin("Michal");
        user.setPassword("Michal");
        user.setRole("Admin");
        userService.create(user);
//        User userAdded = userService.findById(user.getId());
//        rider.setId(userAdded.getId());
//        riderService.create(rider);
        return this.viewPath + "startList";
    }
}
