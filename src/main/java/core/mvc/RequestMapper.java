package core.mvc;

import jwp.controller.*;

import java.util.HashMap;
import java.util.Map;

public class RequestMapper {

    private static final Map<String , Controller> controllers = new HashMap<>();

    static {
        controllers.put("/", new ForwardController("home"));
        controllers.put("/user/form", new ForwardController("/user/form"));
        controllers.put("/user/loginForm", new ForwardController("/user/login"));
        controllers.put("/user/login_failed", new ForwardController("/user/login_failed"));
        controllers.put("/qna/form", new ForwardController("/qna/form.jsp"));
        controllers.put("/qna/show", new ForwardController("/qna/show.jsp"));

        controllers.put("/user/list", new ListUserController());

        controllers.put("/user/login", new LoginController());
        controllers.put("/user/logout", new LogoutController());

        controllers.put("/user/signup", new CreateUserController());

        controllers.put("/user/updateForm", new UpdateUserFormController());
        controllers.put("/user/update", new UpdateUserController());
    }

    public static Controller getController(String uri) {
        return controllers.get(uri);
    }
}
