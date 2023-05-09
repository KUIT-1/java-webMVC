package jwp.controller.qna;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.mvc.*;
import jwp.dao.AnswerDao;
import jwp.dao.QuestionDao;
import jwp.model.Answer;
import jwp.model.Question;
import jwp.support.context.ContextLoaderListener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;
import java.util.logging.Logger;

public class AnswerAddController extends AbstractController {
    AnswerDao answerDao = new AnswerDao();
    QuestionDao questionDao = new QuestionDao();

    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        Answer answer = new Answer(Integer.parseInt(params.get("questionId")), params.get("writer"), params.get("contents"));

        Answer savedAnswer = answerDao.insert(answer);

        Question question = questionDao.findByQuestionId(answer.getQuestionId());
        question.increaseCountOfAnswer();
        questionDao.updateCountOfAnswer(question);

        return jsonView().addObject("answer", savedAnswer); // ModelAndView객체의 Map자료구조에 데이터를 넣음
    }
}
