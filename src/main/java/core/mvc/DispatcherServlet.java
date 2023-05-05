package core.mvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dispatcher", urlPatterns = "/", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {

    /**
     * MVC 패턴을 구현하기 위한 DispatcherServlet 클래스를 정의
     * http 요청을 처리하고, 요청에 대한 적절한 Controller를 선택하여 실행하고,
     * Controller에서 반환한 결과를 적절한 View로 전달하는 역할
     */

    //requestMapping : HTTP 요청과 Controller 간의 매핑을 관리한다.
    private RequestMapping requestMapping;
    // REDIRECT_PREFIX : View 이름이 이 문자열로 시작하면 리다이렉트를 수행
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    public void init() throws ServletException {

        System.out.println("DispatcherServlet init 함수");
        /**
         * 서블릿 초기화 시 호출되는 메서드로, requestMapping 필드를 초기화한다
         */

        requestMapping = new RequestMapping();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**
         * HTTP 요청을 처리하는 메서드로, 요청에 대한 적절한 Controller를 선택하여 실행하고,
         * Controller에서 반환한 결과를 적절한 View로 전달
         */
        System.out.println("DispatcherServlet service 함수");
        Controller controller = requestMapping.getController(req);
        try {
            String viewName = controller.execute(req, resp);
            move(viewName, req, resp);
        } catch (Throwable e) {
            throw new ServletException(e.getMessage());
        }

    }

    private void move(String viewName, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        /**
         * View 이름에 따라 적절한 처리를 수행하는 메서드로,
         * View 이름이 redirect: 로 시작하면 리다이렉트를, 그렇지 않으면 RequestDispatcher을 사용하여 View 로 이동한다.
         */

        if (viewName.startsWith(REDIRECT_PREFIX)) {
            resp.sendRedirect(viewName.substring(REDIRECT_PREFIX.length()));
            return;
        }

        RequestDispatcher rd = req.getRequestDispatcher(viewName);
        System.out.println("DispatcherServlet move 함수");
        rd.forward(req, resp);
    }
}
