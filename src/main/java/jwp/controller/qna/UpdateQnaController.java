package jwp.controller.qna;

import jwp.controller.Controller;
import jwp.dao.QuestionDao;
import jwp.dao.UserDao;
import jwp.model.Question;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateQnaController implements Controller {

    QuestionDao questionDao = new QuestionDao();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        Question question = new Question(
                Integer.parseInt(req.getParameter("questionId")),
                req.getParameter("title"),
                req.getParameter("contents")
        );

        questionDao.update(question);
        return "redirect:/";
    }
}
