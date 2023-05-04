package core.mvc;

import jwp.controller.*;
import jwp.controller.questions.CreateQuestionController;
import jwp.controller.questions.FormQuestionController;
import jwp.controller.questions.ShowQuestionController;
import jwp.controller.user.*;

import java.util.HashMap;
import java.util.Map;

public class RequestMapping {
    // URL, Controller Mapping
    private final Map<String, Controller> mapper = new HashMap<>();

    public void init() {
        mapper.put("/", new HomeController());
        // user
        mapper.put("/user/form", new ForwardController("/user/form.jsp"));
        mapper.put("/user/loginForm", new ForwardController("/user/login.jsp"));
        mapper.put("/user/loginFailed", new ForwardController("/user/loginFailed.jsp"));

        mapper.put("/user/signup", new CreateUserController());
        mapper.put("/user/list", new ListUserController());
        mapper.put("/user/login", new LogInController());
        mapper.put("/user/logout", new LogOutController());
        mapper.put("/user/update", new UpdateUserController());
        mapper.put("/user/updateForm", new UpdateUserFormController());
        //question
        mapper.put("/qna/form", new FormQuestionController());
        mapper.put("/qna/create", new CreateQuestionController());
        mapper.put("/qna/show", new ShowQuestionController());

        // TODO:
        // Question Controller 마저 구현하기 + crud + user 자기 계정 아닌데 수정 가능함.. 이거 수정하기
    }

    public Controller getController(String url) {
        return mapper.get(url);
    }

    public void putController(String url, Controller controller) {
        mapper.put(url, controller);
    }
}
