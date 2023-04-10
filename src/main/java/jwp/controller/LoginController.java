package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = MemoryUserRepository.getInstance().findUserById(req.getParameter("userId"));
        if(user == null || !user.getPassword().equals(req.getParameter("password"))){
            return REDIRECT + "/user/login_failed.jsp";
        }

        HttpSession session = req.getSession();
        session.setAttribute("userId", req.getParameter("userId"));
        return REDIRECT + "/";
    }
}
