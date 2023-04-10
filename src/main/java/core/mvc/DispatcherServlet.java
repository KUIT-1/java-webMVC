package core.mvc;

import jwp.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet{
    RequestMapper requestMapper;
    private static final String REDIRECT = "redirect:";

    @Override
    public void init() throws ServletException {
        this.requestMapper = new RequestMapper();
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String pathAfterRequest = proceed(req, res);

        if(pathAfterRequest.startsWith(REDIRECT)){
            String path = pathAfterRequest.split(":")[1];
            res.sendRedirect(path);
            return;
        }
        RequestDispatcher rd = req.getRequestDispatcher(pathAfterRequest);
        rd.forward(req, res);
        return;
    }

    private String proceed(HttpServletRequest req,HttpServletResponse res){
        String uri = req.getRequestURI();
        Controller controller = requestMapper.get(uri);

        return controller.execute(req, res);
    }

}
