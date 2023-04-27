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
        newUrl = findcss(newUrl);
        if (redirect.equals("true")){
            resp.sendRedirect(newUrl);
            return;
        }
        RequestDispatcher rd = req.getRequestDispatcher(newUrl);
        rd.forward(req,resp);
        return;
    }

    private String findcss(String css){
        if(css.endsWith("css")){
            css = css.replace("/user","");

        }
        return css;
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
//    private core.RequestMapping requestMapping;
//    private static final String REDIRECT_PREFIX = "redirect:";
//
//    @Override
//    public void init() throws ServletException {
//        requestMapping = new core.RequestMapping();
//    }
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Controller controller = requestMapping.getController(req);
//        try {
//            String viewName = controller.execute(req, resp);
//            move(viewName, req, resp);
//        } catch (Throwable e) {
//            throw new ServletException(e.getMessage());
//        }
//    }
//
//    private void move(String viewName, HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        if (viewName.startsWith(REDIRECT_PREFIX)) {
//            resp.sendRedirect(viewName.substring(REDIRECT_PREFIX.length()));
//            return;
//        }
//
//        RequestDispatcher rd = req.getRequestDispatcher(viewName);
//        rd.forward(req, resp);
//    }
}
