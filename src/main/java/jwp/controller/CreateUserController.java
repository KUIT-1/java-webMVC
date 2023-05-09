package jwp.controller;

import core.mvc.*;
import jwp.dao.UserDao;
import jwp.model.User;
import jwp.support.context.ContextLoaderListener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.logging.Logger;


public class CreateUserController extends AbstractController {
    UserDao userDao = new UserDao();
    private static final Logger logger = Logger.getLogger(ContextLoaderListener.class.getName());

    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        User user = new User(params.get("userId"),
                params.get("password"),
                params.get("name"),
                params.get("email"));

        userDao.insert(user);
        return jspView("/user/login.jsp");
    }
}
