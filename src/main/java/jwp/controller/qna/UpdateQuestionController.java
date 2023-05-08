package jwp.controller.qna;

import core.mvc.Controller;
import core.mvc.JspView;
import core.mvc.View;
import jwp.dao.QuestionDao;
import jwp.dao.UserDao;
import jwp.model.Question;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateQuestionController implements Controller {
    QuestionDao questionDao = new QuestionDao();

    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String questionId = req.getParameter("questionId");
        Question question = questionDao.findByQuestionId(Integer.parseInt(questionId));

        question.updateTitleAndContents(req.getParameter("title"),req.getParameter("contents"));
        questionDao.update(question);

        return new JspView("redirect:/");
    }
}
