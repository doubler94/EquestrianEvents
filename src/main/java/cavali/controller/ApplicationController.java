package cavali.controller;

import cavali.entity.Rider.Rider;
import cavali.entity.User.User;
import cavali.service.Rider.RiderService;
import cavali.service.User.UserService;
import cavali.url.AppUrls;
import cavali.url.Login.LoginUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping(value = AppUrls.APP, method = RequestMethod.GET)
    public String viewIndex()
    {
        return "index";
    }

    @RequestMapping(value = AppUrls.APP_COMPETITION,method = RequestMethod.GET)
    public String viewCompetition()
    {
        return viewPath + "competition";
    }

    @RequestMapping(value = AppUrls.APP_START_LIST,method = RequestMethod.GET)
    public String viewStartList()
    {
        return viewPath + "startList";
    }

    @RequestMapping(value = AppUrls.APP_RESULT,method = RequestMethod.GET)
    public String viewResult()
    {
        return viewPath + "resultList";
    }

    @RequestMapping(value = AppUrls.LOGIN, method = GET)
    public String loginPage(ModelMap model){
        model.addAttribute("rider", new Rider());
        model.addAttribute("user", new User());
        return this.viewPath + "login";
    }

    @RequestMapping(value = AppUrls.LOGIN_REGISTER, method = POST)
    @Transactional
    public String registerUser(@ModelAttribute Rider rider, @ModelAttribute User user){
        user.setRole("Admin");
        userService.create(user);
        rider.setUser(user);
        riderService.create(rider);
        return "redirect:" + LoginUrls.LOGIN;
    }

    @RequestMapping(value = AppUrls.LOGOUT, method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

//    private String getPrincipal(){
//        String userName = null;
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (principal instanceof UserDetails) {
//            userName = ((UserDetails)principal).getUsername();
//        } else {
//            userName = principal.toString();
//        }
//        return userName;
//    }
}
