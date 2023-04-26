package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.session.UserSession;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/user/list")
public class ListUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(UserSession.isLogined(request.getSession())){
            request.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            String path = "/user/list.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(path);
            dispatcher.forward(request,response);
            return;
        }
        response.sendRedirect("/user/login.jsp");
    }
}
