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


public class CreateUserController implements Controller {
    UserDao userDao = new UserDao();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        User user = new User(request.getParameter("userId"),
                request.getParameter("password"),
                request.getParameter("name"),
                request.getParameter("email"));
        //MemoryUserRepository.getInstance().addUser(user);
        userDao.insert(user);
        return "redirect:/user/loginForm";
    }
}