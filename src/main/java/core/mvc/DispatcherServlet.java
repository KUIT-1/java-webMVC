package core.mvc;

import jwp.support.context.ContextLoaderListener;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

    private RequestMapping requestMapping;
    private static final Logger logger = Logger.getLogger(ContextLoaderListener.class.getName());

    @Override
    public void init() throws ServletException {
        requestMapping = new RequestMapping();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Controller controller = getController(req,resp);
        if(controller==null){
            return;
        }

        try {
            Map<String, String> map = createParams(req);
            ModelAndView mov = controller.execute(map);
            mov.getView().render(mov.getModel(), req, resp); // view를 rendering 할 때 data가 담긴 model을 전달해준다.
        } catch (Throwable e) {
            throw new ServletException(e.getMessage());
        }
    }

    // 사용자에게 데이터를 전달하는 책임을 갖는 View라는 인터페이스를 구현하는 JsonView객체와 jspView객체를 추가한다.

    private Controller getController(HttpServletRequest request, HttpServletResponse response){
        Controller controller = requestMapping.getController(request);
        //Controller 객체가 null일 때 404 Not Found 에러 나도록 처리
        if(controller==null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
        controller.setSession(request.getSession());
        return controller;
    }

    private Map<String, String> createParams(HttpServletRequest request){
        Map<String, String> params = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(paramName -> params.put(paramName, request.getParameter(paramName)));
        return params;
    }

}
