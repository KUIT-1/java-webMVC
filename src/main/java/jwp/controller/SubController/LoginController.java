package jwp.controller.SubController;


import core.db.MemoryUserRepository;
import jwp.controller.Controller;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        //로그인
        String loginId = req.getParameter("userId");
        String loginPw = req.getParameter("password");

        User user = MemoryUserRepository.getInstance().findUserById(loginId);
        if((user == null) || !user.getPassword().equals(loginPw))
            return "redirect:/user/loginFail";
        HttpSession session = req.getSession();
        session.setAttribute("user", user);

        return "redirect:/";
    }

}
