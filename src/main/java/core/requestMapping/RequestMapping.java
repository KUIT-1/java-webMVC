package core.requestMapping;

import core.controller.Controller;
import jwp.controller.*;

import java.util.HashMap;
import java.util.Map;

public class RequestMapping {
    // URL, Controller Mapping
    private Map<String, Controller> mapper = new HashMap<>();

    public void init() {
        mapper.put("/user/form", new ForwardController("/user/form.jsp"));
        mapper.put("/user/loginForm", new ForwardController("/user/login.jsp"));
        mapper.put("/", new HomeController());
        mapper.put("/user/signup", new CreateUserController());
        mapper.put("/user/list", new ListUserController());
        mapper.put("/user/login", new LogInController());
        mapper.put("/user/logout", new LogOutController());
        mapper.put("/user/update", new UpdateUserController());
        mapper.put("/user/updateForm", new UpdateUserFormController());
    }

    public Controller getController(String url) {
        return mapper.get(url);
    }

    public void putController(String url, Controller controller) {
        mapper.put(url, controller);
    }
}
