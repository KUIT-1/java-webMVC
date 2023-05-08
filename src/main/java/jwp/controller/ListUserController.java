package jwp.controller;

import core.mvc.Controller;
import core.mvc.JspView;
import core.mvc.View;
import jwp.dao.UserDao;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController implements Controller {
    UserDao userDao = new UserDao();

    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (UserSessionUtils.isLogined(req.getSession())) {
            req.setAttribute("users", userDao.findAll());
            return new JspView("/user/list.jsp");
        }
        return new JspView("redirect:/user/loginForm");
    }
}
