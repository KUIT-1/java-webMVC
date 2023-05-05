package jwp.controller.user;

import core.mvc.Controller;
import core.db.MemoryUserRepository;
import jwp.dao.UserDao;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateUserController implements Controller {
    UserDao userDao = new UserDao();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        userDao.update(new User(
                request.getParameter("userId"),
                request.getParameter("password"),
                request.getParameter("name"),
                request.getParameter("email")
        ));
        return "redirect:/user/list";
    }
}