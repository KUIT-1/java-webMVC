package jwp.controller;


import core.db.MemoryUserRepository;
import jwp.model.User;
import org.apache.catalina.users.MemoryUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/user/update")
public class UpdateUserFormController extends HttpServlet {

    User user;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        user = MemoryUserRepository.getInstance().findUserById(userId);
        if(user != null)
            req.setAttribute("user", user);
        RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user.update(new User(
                req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email")
        ));

        MemoryUserRepository.getInstance().changeUserInfo(user);

        resp.sendRedirect("/user/list");
    }
}
