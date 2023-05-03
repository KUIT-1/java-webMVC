package jwp.controller.qna;

import jwp.controller.Controller;
import jwp.dao.QuestionDao;
import jwp.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CreateQnaController implements Controller {
    QuestionDao questionDao = new QuestionDao();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Question question = new Question(
                req.getParameter("writer"),
                req.getParameter("title"),
                req.getParameter("contents"));

        try {
            Question returnQ = questionDao.insert(question);
            System.out.println(returnQ.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/";
    }
}
