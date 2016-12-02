package cavali.controller.Rider;

import cavali.service.Rider.RiderService;
import cavali.url.AppUrls;
import cavali.url.Rider.RiderUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ola on 05.11.2016.
 */
@Controller
@RequestMapping(value = RiderUrls.RIDER)
public class RiderController {

    public static String viewPath = "page/rider/";

    @Autowired
    private RiderService riderService;

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage()
    {
        return viewPath + "mainPage";
    }
}
