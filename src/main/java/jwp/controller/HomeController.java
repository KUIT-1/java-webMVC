package jwp.controller;

import core.mvc.Controller;
import jwp.dao.QuestionDao;
import jwp.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class HomeController implements Controller{
    QuestionDao questionDao = new QuestionDao();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Question> questions = questionDao.findAll();
        request.setAttribute("questions", questions);
        return "/home.jsp";
    }
}