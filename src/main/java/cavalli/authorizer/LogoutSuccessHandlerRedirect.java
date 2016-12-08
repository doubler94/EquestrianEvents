package cavalli.authorizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ola on 08.12.2016.
 */
@Component
public class LogoutSuccessHandlerRedirect implements LogoutSuccessHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("Logout Sucessfull with Principal: "+ authentication.getName());
        System.out.println("Logout Sucessfull with Principal: "+ authentication.getName());
        response.setStatus(HttpServletResponse.SC_OK);
        response.sendRedirect("/");
    }
}
