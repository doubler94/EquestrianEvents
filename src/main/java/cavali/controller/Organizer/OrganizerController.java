package cavali.controller.Organizer;

import cavali.url.Organizer.OrganizerUrls;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Ola on 04.11.2016.
 */
@Controller
@RequestMapping()
public class OrganizerController {

    public static String viewPath = "page/organizer/";

    @RequestMapping(value = OrganizerUrls.ORGANIZER, method = RequestMethod.GET)
    public String mainPage()
    {
        return viewPath + "mainPage";
    }

    @RequestMapping(value = OrganizerUrls.ORGANIZER_COMPETITIONADD, method = RequestMethod.GET)
    public String viewCompetitionAdd()
    {
        return viewPath + "competitionAdd";
    }

    @RequestMapping(value = OrganizerUrls.ORGANIZER_COMPETITIONDELETE, method = RequestMethod.GET)
    public String viewCompetitionDelete()
    {
        return viewPath + "competitionDelete";
    }

    @RequestMapping(value = OrganizerUrls.ORGANIZER_COMPETITIONEDIT, method = RequestMethod.GET)
    public String viewCompetitionEdit() { return viewPath + "competitionEdit"; }

    @RequestMapping(value = OrganizerUrls.ORGANIZER_ADMIN, method = RequestMethod.GET)
    public String viewAdmin() { return viewPath + "admin/admin"; }

    @RequestMapping(value = OrganizerUrls.ORGANIZER_ADMIN_ORGANIZERADD, method = RequestMethod.GET)
    public String viewAdminAdd() { return viewPath + "admin/organizerAdd"; }

    @RequestMapping(value = OrganizerUrls.ORGANIZER_ADMIN_ORGANIZERDELETE, method = RequestMethod.GET)
    public String viewAdminDelete() { return viewPath + "admin/organizerDelete"; }
}
