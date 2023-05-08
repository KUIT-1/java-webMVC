package jwp.controller;

import core.mvc.Controller;
import core.mvc.JspView;
import core.mvc.View;
import jwp.dao.UserDao;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateUserFormController implements Controller {

    UserDao userDao = new UserDao();

    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String userId = req.getParameter("userId");
        User user = userDao.findByUserId(userId);
        if (user != null) {
            req.setAttribute("user",user);
            return new JspView("/user/updateForm.jsp");
        }
        return new JspView("redirect:/");
    }
}
