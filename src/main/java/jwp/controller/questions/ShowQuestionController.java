package jwp.controller.questions;

import core.mvc.Controller;
import jwp.dao.QuestionDao;
import jwp.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ShowQuestionController implements Controller {
    QuestionDao questionDao = new QuestionDao();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int questionId = Integer.parseInt(request.getParameter("questionId"));
        Question question = questionDao.findByQuestionId(questionId);
        request.setAttribute("question", question);
        return "/qna/show.jsp";
    }
}
