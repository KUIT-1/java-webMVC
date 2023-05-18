package jwp.controller;

import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.view;
import jwp.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ListUserController implements Controller {
    private static final String USER_SESSION_KEY = "user";
    UserDao  userDao = new UserDao();
    @Override
    public view execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        HttpSession session = req.getSession();
        Object value = session.getAttribute(USER_SESSION_KEY);

        if (value == null) {
            return new JspView("redirect:/");
        }

        req.setAttribute("users", userDao.findAll());
        return new JspView("/user/list.jsp");
    }
}
