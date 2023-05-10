package jwp.controller;

import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.view;
import jwp.dao.QuestionDao;
import jwp.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HomeController implements Controller {
    QuestionDao questionDao = new QuestionDao();
    @Override
    public view execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Question> questions = questionDao.findAll();
        req.setAttribute("questions", questions);
        return new JspView("home.jsp");
    }
}
