package core;

import jwp.controller.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RequestMapper {
    private static final Map<String, Controller> controllers = new HashMap<>();

    static {
        controllers.put("/",new HomeController());

        controllers.put("/user/form", new ForwardController("/user/form.jsp"));
        controllers.put("/user/loginForm", new ForwardController("/user/login.jsp"));
        controllers.put("/user/loginFailed", new ForwardController("/user/loginFailed.jsp"));

        controllers.put("/user/list", new ListUserController());

        controllers.put("/user/login", new LoginUserController());
        controllers.put("/user/logout", new LogoutUserController());

        controllers.put("/user/signup", new CreateUserController());

        controllers.put("/user/updateForm", new UpdateUserFormController());
        controllers.put("/user/updateUser", new UpdateUserController());
    }


    public Controller getController(HttpServletRequest request) {
        return controllers.get(request.getRequestURI());
    }
}
