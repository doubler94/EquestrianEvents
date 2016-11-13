package cavali.controller;

import cavali.url.AppUrls;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ola on 08.11.2016.
 */
@Controller
public class ApplicationController {

    public static String viewPath = "page/";

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
}
