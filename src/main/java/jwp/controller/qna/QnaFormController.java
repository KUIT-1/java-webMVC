package jwp.controller.qna;

import core.mvc.Controller;
import jwp.dao.QuestionDao;
import jwp.model.Question;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QnaFormController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        if (!UserSessionUtils.isLogined(session)) {
            return "/user/loginForm";
        }

        String questionId = req.getParameter("questionId");
        if (questionId != null) {
            Question question = new QuestionDao().findById(Integer.parseInt(questionId));
            req.setAttribute("question", question);
        } else {
            req.setAttribute("question", new Question("", "", ""));
        }

        return "/qna/form.jsp";
    }
}