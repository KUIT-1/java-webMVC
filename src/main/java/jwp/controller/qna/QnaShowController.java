package jwp.controller.qna;

import core.mvc.Controller;
import core.mvc.JspView;
import core.mvc.View;
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
import java.util.logging.Logger;

public class QnaShowController implements Controller {
    QuestionDao questionDao = new QuestionDao();
    AnswerDao answerDao = new AnswerDao();
    private static final Logger logger = Logger.getLogger(ContextLoaderListener.class.getName());

    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        User user = UserSessionUtils.getUserFromSession(session);

        int questionId = Integer.parseInt(req.getParameter("questionId"));
        Question question = questionDao.findByQuestionId(questionId);

        if (question != null){
            req.setAttribute("loginUser", user);
            req.setAttribute("question", question);
            req.setAttribute("answers", answerDao.findAllByquestionId(questionId));
            logger.info(answerDao.findAllByquestionId(questionId).toString());
            logger.info(req.getParameter("questionId"));
            return new JspView("/qna/show.jsp");
        }

        return new JspView("redirect:/");
    }
}
