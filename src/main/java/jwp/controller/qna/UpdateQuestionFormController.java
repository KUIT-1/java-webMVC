package jwp.controller.qna;

import core.mvc.Controller;
import core.mvc.JspView;
import core.mvc.View;
import jwp.dao.QuestionDao;
import jwp.dao.UserDao;
import jwp.model.Question;
import jwp.model.User;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;


public class UpdateQuestionFormController implements Controller {
    QuestionDao questionDao = new QuestionDao();

    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        if (!UserSessionUtils.isLogined(session)) {
            return new JspView("redirect:/users/loginForm");
        }

        String questionId = req.getParameter("questionId");
        Question question = questionDao.findByQuestionId(Integer.parseInt(questionId));

        if (!question.isSameUser(Objects.requireNonNull(UserSessionUtils.getUserFromSession(session)))) {
            throw new IllegalArgumentException();
        }
        req.setAttribute("question",question);
        return new JspView("/qna/updateForm.jsp");
    }
}
