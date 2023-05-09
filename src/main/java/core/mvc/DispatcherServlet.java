package core.mvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

    private RequestMapping requestMapping;
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    public void init() throws ServletException {
        requestMapping = new RequestMapping();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Controller controller = getController(req, resp);
        if(controller == null) return;
        try {
            ModelAndView mav = controller.execute(createParams(req));
            mav.getView().render(mav.getModel(), req, resp);
        } catch (Throwable e) {
            throw new ServletException(e.getMessage());
        }
    }

    private Controller getController(HttpServletRequest req, HttpServletResponse resp) {
        Controller controller = requestMapping.getController(req);
        if(controller == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        controller.setSession(req.getSession());
        return controller;
    }

    private Map<String, String> createParams(HttpServletRequest request){
        Map<String, String> params = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> params.put(paramName, request.getParameter(paramName)));
        return params;
    }
}
