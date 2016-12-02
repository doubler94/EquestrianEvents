package cavali.controller.Admin;

import cavali.url.Admin.AdminUrls;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Ola on 04.11.2016.
 */
@Controller
@RequestMapping(value = AdminUrls.ADMIN)
public class AdminController {

    public static String viewPath = "page/organizer/";

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage()
    {
        return viewPath + "mainPage";
    }
}
