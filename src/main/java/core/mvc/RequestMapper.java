package core.mvc;

import jwp.controller.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RequestMapper extends HttpServlet {
    private static final Map<String, Controller> controllers = new HashMap<>();

    static {
        controllers.put("/user/loginForm", new ForwardController("/user/login.jsp"));
        controllers.put("/user/loginFailed", new ForwardController("/user/login_failed.jsp"));
        controllers.put("/user/signupForm", new ForwardController("/user/form.jsp"));
        controllers.put("/qna/form", new ForwardController("/qna/form.jsp"));
        controllers.put("/qna/show", new ForwardController("/qna/show.jsp"));

        controllers.put("/user/signup", new CreateUserController());
        controllers.put("/user/login", new LoginController());
        controllers.put("/user/userList", new ListUserController());
        controllers.put("/", new HomeController());
        controllers.put("/user/logout",new LogoutController());
        controllers.put("/user/update", new UpdateUserController());
        controllers.put("/user/updateForm", new UpdateUserFormController());
    }

    public static Controller getController(String requestUrl){
        Controller controller = controllers.get(requestUrl);
        if(controller != null){
            return controller;
        }
        return controllers.get("/");
    }
}
