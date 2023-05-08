package jwp.controller.qna;

import core.mvc.Controller;
import core.mvc.JspView;
import core.mvc.View;
import jwp.dao.QuestionDao;
import jwp.model.Question;
import jwp.model.User;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddQuestionController implements Controller {
    QuestionDao questionDao = new QuestionDao();
    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Question question = new Question(req.getParameter("writer"),
                req.getParameter("title"),
                req.getParameter("contents"));

        questionDao.insert(question);
        return new JspView("redirect:/");
    }
}
