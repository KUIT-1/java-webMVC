package jwp.controller;

<<<<<<< HEAD
import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/signup")
public class CreateUserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
=======
import core.mvc.Controller;
import jwp.dao.UserDao;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateUserController implements Controller {
    UserDao userDao = new UserDao();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
>>>>>>> f0a8f3d (server 5주차 미션 1-2까지”)
        User user = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));

<<<<<<< HEAD
        MemoryUserRepository.getInstance().addUser(user);
        System.out.println("??");
        resp.sendRedirect("/user/list");
=======
        userDao.insert(user);
        return "redirect:/user/list";
>>>>>>> f0a8f3d (server 5주차 미션 1-2까지”)
    }
}
