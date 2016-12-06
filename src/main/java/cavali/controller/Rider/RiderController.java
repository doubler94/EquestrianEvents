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
@RequestMapping()
public class RiderController {

    public static String viewPath = "page/rider/";

    @Autowired
    private RiderService riderService;

    @RequestMapping(value = RiderUrls.RIDER, method = RequestMethod.GET)
    public String mainPage()
    {
        return viewPath + "mainPage";
    }

    @RequestMapping(value = RiderUrls.RIDER_HORSEREGISTER, method = RequestMethod.GET)
    public String viewHorseRegister()
    {
        return viewPath + "horseRegister";
    }

    @RequestMapping(value = RiderUrls.RIDER_HORSEEDIT, method = RequestMethod.GET)
    public String viewHorseEdit()
    {
        return viewPath + "horseEdit";
    }

    @RequestMapping(value = RiderUrls.RIDER_HORSEDELETE, method = RequestMethod.GET)
    public String viewHorseDelete()
    {
        return viewPath + "horseDelete";
    }

    @RequestMapping(value = RiderUrls.RIDER_RIDEREDIT, method = RequestMethod.GET)
    public String viewRiderEdit()
    {
        return viewPath + "riderEdit";
    }
}
