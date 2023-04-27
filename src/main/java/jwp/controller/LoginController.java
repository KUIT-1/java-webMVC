package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;
import jwp.util.UserSessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Logger;

public class LoginController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginid = req.getParameter("userId");
        String loginpw = req.getParameter("password");
        User loginUser = new User(loginid, loginpw);
        User user = MemoryUserRepository.getInstance().findUserById(loginid);

        if(user != null && user.isSameUser(loginUser)){
            HttpSession session = req.getSession();
            UserSessionUtil.login(session, user);
            return "Redirect:/";
        }

        return "Redirect:/user/loginFailed";
    }
}
