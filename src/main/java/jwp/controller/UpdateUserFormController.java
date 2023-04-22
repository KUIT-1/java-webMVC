package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/updateForm")
public class UpdateUserFormController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User userById = MemoryUserRepository.getInstance().findUserById(req.getParameter("userId"));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/updateForm.jsp");
        req.setAttribute("user", userById);

        requestDispatcher.forward(req, resp);
        super.doGet(req, resp);
    }
}
