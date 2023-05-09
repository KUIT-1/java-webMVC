package jwp.controller.qna;

import core.mvc.*;
import jwp.dao.AnswerDao;
import jwp.dao.QuestionDao;
import jwp.model.Answer;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class ShowController extends AbstractController {
    QuestionDao questionDao = new QuestionDao();
    AnswerDao answerDao = new AnswerDao();

    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        String questionId = params.get("questionId");
        Question question = questionDao.findByQuestionId(Integer.parseInt(questionId));
        List<Answer> answers = answerDao.findAllByQuestionId(Integer.parseInt(questionId));

        return jspView("/qna/show.jsp")
                .addObject("question", question)
                .addObject("answers", answers);
    }
}
