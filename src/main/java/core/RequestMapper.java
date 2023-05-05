package core;

import jwp.controller.*;
import jwp.controller.qna.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RequestMapper {
    private static final Map<String, Controller> controllers = new HashMap<>();

    static {
        controllers.put("/",new HomeController());
        controllers.put("/home", new HomeController());

        controllers.put("/user/form", new ForwardController("/user/form.jsp"));
        controllers.put("/user/loginForm", new ForwardController("/user/login.jsp"));
        controllers.put("/user/loginFailed", new ForwardController("/user/loginFailed.jsp"));

        controllers.put("/qna/create", new CreateQnaController());
        controllers.put("/qna/form",new QnaFormController());
        controllers.put("/qna/show",new ShowQnaController());
        controllers.put("/qna/updateform",new UpdateFormQnaController());
        controllers.put("/qna/update",new UpdateQnaController());
        controllers.put("/qna/delete",new DeleteQnaController());
        controllers.put("/api/qna/addAnswer",new AddAnswerController());

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
