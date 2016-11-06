package cavali.controller.User;

import cavali.service.User.UserService;
import cavali.url.User.UserUrls;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

/**
 * Created by Ola on 05.11.2016.
 */
@Controller
@RequestMapping(UserUrls.USER)
public class UserController {

    @Inject
    UserService userService;

    private String viewPath = "templates/page/user";
}
