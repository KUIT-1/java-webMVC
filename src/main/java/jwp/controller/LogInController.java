package jwp.controller;

import core.mvc.Controller;
import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogInController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        User logInUser = new User(userId, password, name, email);
        User user = MemoryUserRepository.getInstance().findUserById(userId);

        if (user!=null && user.isSameUser(logInUser)) {
            session.setAttribute("user", user);
            return "redirect:/";
        }
        return "redirect:/user/login_failed.jsp";
    }
}