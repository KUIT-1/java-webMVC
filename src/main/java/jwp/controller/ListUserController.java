package jwp.controller;

import core.db.MemoryUserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ListUserController implements Controller {
    private static final String USER_SESSION_KEY = "user";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        HttpSession session = req.getSession();
        Object value = session.getAttribute(USER_SESSION_KEY);
        if (value == null) {
            return "redirect:/";
        }

        req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
        return "/user/list.jsp";
    }
}
