package cavali.controller.Rider;

import cavali.service.Rider.RiderService;
import cavali.url.Rider.RiderUrls;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

/**
 * Created by Ola on 05.11.2016.
 */
@Controller
@RequestMapping(RiderUrls.RIDER)
public class RiderController {

    @Inject
    private RiderService riderService;

    private String viewPath = "templates/page/rider";
}
