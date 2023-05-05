package jwp.controller;

<<<<<<< HEAD
import core.db.MemoryUserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/list")
public class ListUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
        RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
        rd.forward(req,resp);
=======
import core.mvc.Controller;
import jwp.dao.QuestionDao;
import jwp.dao.UserDao;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController implements Controller {
    UserDao userDao = new UserDao();


    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (UserSessionUtils.isLogined(req.getSession())) {
            req.setAttribute("users", userDao.findAll());
            return "/user/list.jsp";
        }
        return "redirect:/user/loginForm";
>>>>>>> f0a8f3d (server 5주차 미션 1-2까지”)
    }
}
