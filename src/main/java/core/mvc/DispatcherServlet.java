package core.mvc;

import jwp.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Controller controller = RequestMapper.getController(req.getRequestURI());
        String requestUrl = controller.execute(req, resp);
        proceed(req, resp, requestUrl);
    }

    private void proceed(HttpServletRequest req, HttpServletResponse resp, String requestUrl) throws IOException, ServletException {
        if(requestUrl.startsWith("Redirect:")){
            String url = requestUrl.split(":")[1];
            resp.sendRedirect(url);
            return;
        }

        RequestDispatcher rd = req.getRequestDispatcher(requestUrl);
        rd.forward(req, resp);
    }
}
