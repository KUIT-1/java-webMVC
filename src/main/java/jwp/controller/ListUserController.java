package jwp.controller;

import core.db.MemoryUserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListUserController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        Object value = session.getAttribute("user");

        if (value == null) {
            return "redirect:/user/loginForm";
        }

        req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
        return "/user/list";
    }
}
