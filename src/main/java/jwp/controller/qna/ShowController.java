package jwp.controller.qna;

import core.mvc.Controller;
import core.mvc.JspView;
import core.mvc.View;
import jwp.dao.AnswerDao;
import jwp.dao.QuestionDao;
import jwp.model.Answer;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowController implements Controller {
    QuestionDao questionDao = new QuestionDao();
    AnswerDao answerDao = new AnswerDao();
    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String questionId = req.getParameter("questionId");
        Question question = questionDao.findByQuestionId(Integer.parseInt(questionId));
        List<Answer> answers = answerDao.findAllByQuestionId(Integer.parseInt(questionId));
        req.setAttribute("question", question);
        req.setAttribute("answers", answers);

        return new JspView("/qna/show.jsp");
    }
}
