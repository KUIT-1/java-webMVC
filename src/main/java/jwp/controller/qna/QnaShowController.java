package jwp.controller.qna;

import core.mvc.*;
import jwp.dao.AnswerDao;
import jwp.dao.QuestionDao;
import jwp.model.Answer;
import jwp.model.Question;
import jwp.model.User;
import jwp.support.context.ContextLoaderListener;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.logging.Logger;

public class QnaShowController extends AbstractController {
    QuestionDao questionDao = new QuestionDao();
    AnswerDao answerDao = new AnswerDao();
    private static final Logger logger = Logger.getLogger(ContextLoaderListener.class.getName());

    HttpSession session;

    @Override
    public void setSession(HttpSession httpSession) {
        this.session = httpSession;
    }

    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        User user = UserSessionUtils.getUserFromSession(session);

        int questionId = Integer.parseInt(params.get("questionId"));
        Question question = questionDao.findByQuestionId(questionId);

        if (question != null){
            ModelAndView mov = jspView("/qna/show.jsp");
            mov.addObject("loginUser", user).addObject("question", question).addObject("answers", answerDao.findAllByquestionId(questionId));
            logger.info(answerDao.findAllByquestionId(questionId).toString());
            logger.info(params.get("questionId"));
            return mov;
        }

        return jspView("redirect:/");
    }
}
