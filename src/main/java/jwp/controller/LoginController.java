package jwp.controller;


import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/user/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //로그인
        String loginId = req.getParameter("userId");
        String loginPw = req.getParameter("password");

        User user = MemoryUserRepository.getInstance().findUserById(loginId);
        if(user == null)
            resp.sendRedirect("/user/loginFailed.jsp");

        if(!user.getPassword().equals(loginPw))
            resp.sendRedirect("/user/loginFailed.jsp");

        HttpSession session = req.getSession();
        session.setAttribute("user", user);


        resp.sendRedirect("/");
    }
}
