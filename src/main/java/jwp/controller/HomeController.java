package jwp.controller;

<<<<<<< HEAD
import core.mvc.Controller;
import jwp.dao.QuestionDao;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HomeController implements Controller {
    QuestionDao questionDao=new QuestionDao();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        req.setAttribute("questions", questionDao.findAll());
        return "/home.jsp";
=======

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HomeController doGet() 실행됨");
        RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
        rd.forward(req,resp);
>>>>>>> 0ae3de14b2a46d613396668cc8c5d3d0f43488e3
    }
}
