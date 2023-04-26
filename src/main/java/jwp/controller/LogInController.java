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

@WebServlet("/user/login")
public class LogInController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        User logInUser = new User(userId, password, name, email);
        User user = MemoryUserRepository.getInstance().findUserById(userId);

        if (user != null && user.isSameUser(logInUser)) {
            session.setAttribute("user", user); // 세션 정보 저장
            response.sendRedirect("/");
            return;
        }
        response.sendRedirect("/user/login_failed.jsp");
    }
}