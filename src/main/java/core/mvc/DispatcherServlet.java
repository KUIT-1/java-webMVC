package core.mvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// loadOnStartup 설정을 하지 않을 경우 서블릿 인스턴스 생성과 초기화는 서블릿 컨테이너가 시작을 완료한 후 클라이언트의 요청이 최초로
// 발생한 시점에 진행된다.
// loadOnStartup 설정을 해줌으로써 서블릿 컨테이너가 시작하는 시점에 서블릿 인스턴스 생성, 초기화가 진행되도록 할 수 있다.
@WebServlet(name="dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect:";
    private RequestMapping requestMapping;

    @Override
    public void init() throws ServletException{
        if(requestMapping == null){
            requestMapping = new RequestMapping();
            requestMapping.init();
        }
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String uri = request.getRequestURI();
        //System.out.println(uri);
        Controller controller = requestMapping.getController(uri);
        // request uri 에 따른 적당한 Controller 를 꺼내옴
        try{
            String viewName = controller.execute(request, response);
            move(viewName, request, response);
        } catch(Throwable e){
            throw new ServletException(e.getMessage());
        }
    }
    private void move(String viewName, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        if(isRedirectURI(viewName)){
            response.sendRedirect(viewName.substring(REDIRECT_PREFIX.length())); // redirect
            return;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
        dispatcher.forward(request, response);
    }

    private static boolean isRedirectURI(String viewName) {
        return viewName.startsWith(REDIRECT_PREFIX);
    }
}
