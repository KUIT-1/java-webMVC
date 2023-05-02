package jwp.controller.qna;

import jwp.controller.Controller;
import jwp.dao.QuestionDao;
import jwp.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ShowQnaController implements Controller {
    QuestionDao questionDao = new QuestionDao();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        Question question = questionDao.findByQuestionId(Integer.parseInt(req.getParameter("questionId")));
        if(question == null) return "redirect:/";
        req.setAttribute("question",question);
        return "show.jsp";
    }
}
