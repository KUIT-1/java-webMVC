package jwp.controller.qna;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.mvc.Controller;
import core.mvc.JsonView;
import core.mvc.View;
import jwp.dao.AnswerDao;
import jwp.dao.QuestionDao;
import jwp.model.Answer;
import jwp.model.Question;
import jwp.support.context.ContextLoaderListener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class AnswerAddController implements Controller {
    AnswerDao answerDao = new AnswerDao();
    QuestionDao questionDao = new QuestionDao();
    private static final Logger logger = Logger.getLogger(ContextLoaderListener.class.getName());
    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Answer answer = new Answer(Integer.parseInt(req.getParameter("questionId")), req.getParameter("writer"), req.getParameter("contents"));

        Answer savedAnswer = answerDao.insert(answer);

        Question question = questionDao.findByQuestionId(answer.getQuestionId());
        question.increaseCountOfAnswer();
        questionDao.updateCountOfAnswer(question);

        req.setAttribute("answer", savedAnswer);

        return new JsonView();
    }
}
