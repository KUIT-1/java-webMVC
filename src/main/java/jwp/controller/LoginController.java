package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        MemoryUserRepository repository = MemoryUserRepository.getInstance();
        User userById = repository.findUserById(userId);

        if (userById == null) {
            return "redirect:/user/login_failed";
        }
        if (!userById.matchPassword(password)) {
            return "redirect:/user/login_failed";
        }

        HttpSession session = req.getSession();
        session.setAttribute("user", userById);
        return "redirect:/";
    }
}
