package core;

import jwp.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
    RequestMapper requestMapper;
    private String redirect;
    @Override
    public void init() throws ServletException {
        this.requestMapper = new RequestMapper();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newUrl = proceed(req,resp);
        newUrl = findRedirect(newUrl);
        if (redirect.equals("true")){
            resp.sendRedirect(newUrl);
            return;
        }
        RequestDispatcher rd = req.getRequestDispatcher(newUrl);
        rd.forward(req,resp);
        return;
    }

    private String findRedirect(String url){
        this.redirect = "false";
        if(url.startsWith("redirect")){
            String redirectUrl = url.split(":")[1];
            this.redirect = "true";
            System.out.println(redirectUrl);
            return redirectUrl;
        }
        return url;
    }

    public String proceed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        Controller controller = requestMapper.getController(url);
        return controller.execute(req, resp);
    }
}
