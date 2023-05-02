package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.dao.UserDao;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateUserController implements Controller{

    UserDao userDao = new UserDao();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        User user = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));

        userDao.update(user);
        return "redirect:/user/list";
    }
}
