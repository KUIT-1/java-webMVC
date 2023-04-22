package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/updateForm")
public class UpdateUserFormController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 세션에 저장된 정보 가져오기
        HttpSession session = req.getSession();
        Object value = session.getAttribute("user");
        if (value == null) {
            resp.sendRedirect("/user/login.jsp");
            return;
        }
        User sessionUser = (User) value;
        User userById = MemoryUserRepository.getInstance().findUserById(req.getParameter("userId"));

        if (!userById.isSameUser(sessionUser.getUserId())) {
            resp.sendRedirect("/user/list");
            return;
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user/updateForm.jsp");
        req.setAttribute("user", userById);

        requestDispatcher.forward(req, resp);
        super.doGet(req, resp);
    }
}
