package jwp.controller.Dispatcher;


import jwp.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.StringTokenizer;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    RequestMapping requestMapping = new RequestMapping();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Controller controller = requestMapping.getController(req);
        String toUrl = "/";
        if(controller != null)
            toUrl = controller.execute(req, resp);

        //redirect
        if(toUrl.contains("redirect")) {
            StringTokenizer st = new StringTokenizer(toUrl, ":");
            st.nextToken();
            String redirectUrl = st.nextToken();
            resp.sendRedirect(redirectUrl);
            return;
        }
        //일반
        RequestDispatcher rd = req.getRequestDispatcher(toUrl);
        rd.forward(req, resp);
    }
}
