package jwp.controller.qna;

import core.mvc.Controller;
import jwp.dao.QuestionDao;
import jwp.model.Question;
import jwp.model.User;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QnaUpdateFormController implements Controller {
    QuestionDao questionDao = new QuestionDao();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int questionId = Integer.parseInt(req.getParameter("questionId"));
        Question question = questionDao.findByQuestionId(questionId);

        HttpSession session = req.getSession();
        User loginUser = UserSessionUtils.getUserFromSession(session);

        assert loginUser != null;
        if(!question.isSameUser(loginUser)){
            throw new IllegalArgumentException();
        }

        req.setAttribute("question",question);
        return "/qna/updateForm.jsp";
    }
}
