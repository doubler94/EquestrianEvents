package cavalli.config;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ola on 07.12.2016.
 */

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String attributeName = request.getParameter("attributeName");
        String attributeValue = request.getParameter("attributeValue");
        request.getSession().setAttribute(attributeName, attributeValue);
        response.sendRedirect(request.getContextPath() + "/");
    }

    private static final long serialVersionUID = 2878267318695777395L;
}
