package cavali.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Ola on 04.11.2016.
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @RequestMapping(method = GET)
    public String login()
    {
        return "index";
    }
}
