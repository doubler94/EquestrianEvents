package cavalli.controller.Organizer;

import cavalli.entity.Competition.Competition;
import cavalli.entity.User.User;
import cavalli.exception.Competition.CompetitionNotFoundException;
import cavalli.service.Competition.CompetitionService;
import cavalli.service.User.UserService;
import cavalli.url.Organizer.OrganizerUrls;
import cavalli.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Ola on 04.11.2016.
 */
@Controller
public class OrganizerController {

    public static String viewPath = "page/organizer/";

    @Autowired
    CompetitionService competitionService;

    @Autowired
    UserService userService;

    @Autowired
    MessageSource messageSource;

    private String[] args = {};

    UserUtils userUtils = new UserUtils();

    @RequestMapping(value = OrganizerUrls.ORGANIZER, method = RequestMethod.GET)
    public String mainPage(ModelMap model) {
        String userLogged = userUtils.getPrincipal();
        model.addAttribute("userLogged", userLogged);
        return this.viewPath + "mainPage";
    }

    @RequestMapping(value = OrganizerUrls.ORGANIZER_COMPETITIONADD, method = RequestMethod.GET)
    public String viewCompetitionAdd(ModelMap model) {
        model.addAttribute("competition", new Competition());
        model.addAttribute("user", new User());
        return this.viewPath + "competitionAdd";
    }

    @RequestMapping(value = OrganizerUrls.ORGANIZER_COMPETITIONDELETE, method = RequestMethod.GET)
    public String viewCompetitionDelete(@ModelAttribute Competition competition, ModelMap model) {

        model.addAttribute("competitionList", competitionService.findAll());

        return viewPath + "competitionDelete";
    }

    @RequestMapping(value = OrganizerUrls.ORGANIZER_COMPETITIONEDIT, method = RequestMethod.GET)
    public String viewCompetitionEdit() {
        return viewPath + "competitionEdit";
    }

    @RequestMapping(value = OrganizerUrls.ORGANIZER_ADMIN, method = RequestMethod.GET)
    public String viewAdmin() {
        return viewPath + "admin/admin";
    }

    @RequestMapping(value = OrganizerUrls.ORGANIZER_ADMIN_ORGANIZERADD, method = RequestMethod.GET)
    public String viewAdminAdd() {
        return viewPath + "admin/organizerAdd";
    }

    @RequestMapping(value = OrganizerUrls.ORGANIZER_ADMIN_ORGANIZERDELETE, method = RequestMethod.GET)
    public String viewAdminDelete() {
        return viewPath + "admin/organizerDelete";
    }

    @RequestMapping(value = OrganizerUrls.ORGANIZER_COMPETITION_ADD, method = POST)
    @Transactional
    public String addCompetition(@ModelAttribute("competition") Competition competition) {
        User user = userService.findBylogin(userUtils.getPrincipal());
        competition.setUser(user);
        competitionService.create(competition);
        return "redirect:" + OrganizerUrls.ORGANIZER;
    }

    @RequestMapping(value = OrganizerUrls.ORGANIZER_COMPETITION_DELETE, method = POST)
    public String deleteCompetition(@ModelAttribute("competition") Competition competition, RedirectAttributes attributes, Locale locale) throws CompetitionNotFoundException {
        competitionService.delete(competition.getId());
        Competition comp = competitionService.findById(competition.getId());
        if(comp==null)
            attributes.addFlashAttribute("success", messageSource.getMessage("competition.delete.success", args, locale));
        else
            attributes.addFlashAttribute("error", messageSource.getMessage("competition.delete.error", args, locale));
        return "redirect:" + OrganizerUrls.ORGANIZER;
    }

//    @RequestMapping(value = OrganizerUrls.ORGANIZER_ADMIN_ORGANIZERDELETE, method = RequestMethod.GET)
//    public String deleteCompetition() {
//        return viewPath + "admin/organizerDelete";
//    }
//
//    @RequestMapping(value = OrganizerUrls.ORGANIZER_ADMIN_ORGANIZERDELETE, method = RequestMethod.GET)
//    public String editCompetition() {
//        return viewPath + "admin/organizerDelete";
//    }


}
