package core.mvc;

import jwp.controller.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RequestMapping {

    /**
     * HTTP 요청과 Controller 간의 매핑을 관리
     * InitControllers() 에서는 URL과 Controller의 매핑 설정
     * getController() 에서는 HTTP 요청에 대한 적절한 Controller를 반환
     */

    private Map<String , Controller> controllers = new HashMap<>();

    public RequestMapping() {
        initControllers();
    }

    private void initControllers() {

        System.out.println("RequestMapping initControllers 함수");

        controllers.put("/", new HomeController());

        controllers.put("/user/form", new ForwardController("/user/form.jsp"));
        controllers.put("/user/loginForm", new ForwardController("/user/login.jsp"));
        controllers.put("/user/loginFailed", new ForwardController("/user/loginFailed.jsp"));
        controllers.put("/qna/form", new ForwardController("/qna/form.jsp"));
        controllers.put("/qna/show", new ForwardController("/qna/show.jsp"));

        controllers.put("/user/list", new ListUserController());

        controllers.put("/user/login", new LogInController());
        controllers.put("/user/logout", new LogOutController());

        controllers.put("/user/signup", new CreateUserController());

        controllers.put("/user/updateForm", new UpdateUserFormController());
        controllers.put("/user/update", new UpdateUserController());

        controllers.put("/qna/create", new CreateQnaController());
    }

    public Controller getController(HttpServletRequest request) {
        System.out.println("RequestMapping getControllers 함수");
        return controllers.get(request.getRequestURI());
    }


}
