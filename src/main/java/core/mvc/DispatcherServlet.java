package core.mvc;

import jwp.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

    private final String REDIRECT = "redirect:";
    private final String SUFFIX = ".jsp";

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI(); // "/front-controller/v3/members/new-form" <- 이거 들어옴
        Controller controller = RequestMapper.getController(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        String view = controller.execute(request, response);

        if (view.startsWith(REDIRECT)) {
            response.sendRedirect(view.replace(REDIRECT, ""));
            return;
        }

        String viewPath = view + SUFFIX;
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        requestDispatcher.forward(request, response);
    }

}
