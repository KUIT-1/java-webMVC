package jwp.controller.user;

import core.mvc.Controller;
import core.db.MemoryUserRepository;
import jwp.dao.UserDao;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class LogInController implements Controller {
    UserDao userDao = new UserDao();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        User logInUser = new User(userId, password, name, email);
        // User user = MemoryUserRepository.getInstance().findUserById(userId);
        User user = userDao.findByUserId(userId);

        if (user!=null && user.isSameUser(logInUser)) {
            session.setAttribute("user", user);
            return "redirect:/";
        }
        return "redirect:/user/loginFailed";
    }
}