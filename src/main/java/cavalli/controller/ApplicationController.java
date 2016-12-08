package cavalli.controller;

import cavalli.entity.Rider.Rider;
import cavalli.entity.User.User;
import cavalli.service.Rider.RiderService;
import cavalli.service.User.UserService;
import cavalli.url.AppUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.security.Principal;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Ola on 08.11.2016.
 */
@Controller
public class ApplicationController {

    public static String viewPath = "page/";

    @Autowired
    RiderService riderService;

    @Autowired
    UserService userService;

    BCryptPasswordEncoder passwordEncoder;

    ApplicationController (){
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @RequestMapping(value = AppUrls.APP, method = RequestMethod.GET)
    public String viewIndex() {
        return "index";
    }

    @RequestMapping(value = AppUrls.APP_COMPETITION, method = RequestMethod.GET)
    public String viewCompetition() {
        return viewPath + "competition";
    }

    @RequestMapping(value = AppUrls.APP_START_LIST, method = RequestMethod.GET)
    public String viewStartList() {
        return viewPath + "startList";
    }

    @RequestMapping(value = AppUrls.APP_RESULT, method = RequestMethod.GET)
    public String viewResult() {
        return viewPath + "resultList";
    }

    @RequestMapping(value = AppUrls.LOGIN, method = GET)
    public String loginPage(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth instanceof AnonymousAuthenticationToken) {
            model.addAttribute("rider", new Rider());
            model.addAttribute("user", new User());
            return this.viewPath + "login";
        }
        else {
                return "redirect:" + AppUrls.APP;
        }
    }

    @RequestMapping(value = AppUrls.LOGIN_REGISTER, method = POST)
    @Transactional
    public String registerUser(@ModelAttribute Rider rider, @ModelAttribute User user) {
        user.setRole("ROLE_ADMIN");
        String password = user.getPassword();
        String hashedPassword = passwordEncoder.encode(password);
        user.setPassword(hashedPassword);

        userService.create(user);
        rider.setUser(user);
        riderService.create(rider);
        return "redirect:" + AppUrls.LOGIN;
    }

    @RequestMapping(value = AppUrls.LOGOUT, method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:" + AppUrls.APP;
    }
}
