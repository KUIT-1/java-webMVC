package jwp.controller;

import core.mvc.Controller;
import core.mvc.JspView;
import core.mvc.View;
import jwp.dao.UserDao;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateUserController implements Controller {
    UserDao userDao = new UserDao();

    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        userDao.update(new User(
                req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email")));
        return new JspView("redirect:/user/list");

    }
}
