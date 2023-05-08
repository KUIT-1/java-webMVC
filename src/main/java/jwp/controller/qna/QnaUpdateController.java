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
import javax.servlet.http.HttpSession;

public class QnaUpdateController implements Controller {
    QuestionDao questionDao = new QuestionDao();
    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        User loginUser = UserSessionUtils.getUserFromSession(session);

        int questionId = Integer.parseInt(req.getParameter("questionId"));
        Question question = questionDao.findByQuestionId(questionId);

        assert loginUser != null;
        if(!question.isSameUser(loginUser)){
            throw new IllegalArgumentException();
        }

        question.update(req.getParameter("title"),
                req.getParameter("contents"));

        questionDao.update(question);

        return new JspView("redirect:/");
    }
}
