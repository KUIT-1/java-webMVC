package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.dao.UserDao;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


public class LoginUserController implements Controller {
    UserDao userDao = new UserDao();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        String userId = req.getParameter("userId");
        User user = userDao.findByUserId(userId);

        System.out.println(userId);

        HttpSession session = req.getSession();
        session.setAttribute("user",user);

        return "redirect:/user/list";
    }
}
