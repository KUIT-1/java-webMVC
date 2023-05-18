package jwp.controller.qna;

import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.view;
import jwp.dao.QuestionDao;
import jwp.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateFormQnaController implements Controller {

    QuestionDao questionDao = new QuestionDao();
    @Override
    public view execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        Question question = questionDao.findByQuestionId(Integer.parseInt(req.getParameter("questionId")));
        req.setAttribute("question",question);

        return new JspView("/qna/updateform.jsp");
    }
}