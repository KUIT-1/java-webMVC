package jwp.controller.Dispatcher;

import jwp.controller.*;
import jwp.controller.SubController.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class RequestMapping {

    private HashMap<String, Controller> map = new HashMap<>();

    public RequestMapping() {
        map.put("/", new HomeController());

        map.put("/qna/form" ,new ForwardController("/qna/form.jsp"));
        map.put("/qna/show", new ForwardController("/qna/show.jsp"));

        map.put("/user/form", new ForwardController("/user/form.jsp"));
        map.put("/user/ulist", new ForwardController("/user/list.jsp"));
        map.put("/user/loginForm", new ForwardController("/user/login.jsp"));
        map.put("/user/loginFail", new ForwardController("/user/login_failed.jsp"));
        map.put("/user/updateUserForm", new ForwardController("/user/updateForm.jsp"));

        map.put("/user/list", new ListUserController());
        map.put("/user/login", new LoginController());
        map.put("/user/logout", new LogoutController());
        map.put("/user/signup", new CreateUserController());
        map.put("/user/updateForm", new UpdateUserFormController());
        map.put("/user/update", new UpdateController());
    }

    public Controller getController(HttpServletRequest req) {
            return map.get(req.getRequestURI());
    }
}
