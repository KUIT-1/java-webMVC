package jwp.controller;

import core.mvc.Controller;
import jwp.dao.UserDao;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateUserController implements Controller {
    UserDao userDao = new UserDao();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));

<<<<<<< HEAD
        userDao.insert(user);
        return "redirect:/user/list";
=======
        MemoryUserRepository.getInstance().addUser(user);
        resp.sendRedirect("/user/list");
>>>>>>> 0ae3de14b2a46d613396668cc8c5d3d0f43488e3
    }
}
