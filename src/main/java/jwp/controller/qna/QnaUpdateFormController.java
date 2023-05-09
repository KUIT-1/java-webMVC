package jwp.controller.qna;

import core.mvc.*;
import jwp.dao.QuestionDao;
import jwp.model.Question;
import jwp.model.User;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class QnaUpdateFormController extends AbstractController {
    QuestionDao questionDao = new QuestionDao();
    HttpSession session;

    @Override
    public void setSession(HttpSession httpSession) {
        this.session = httpSession;
    }
    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        int questionId = Integer.parseInt(params.get("questionId"));
        Question question = questionDao.findByQuestionId(questionId);

        User loginUser = UserSessionUtils.getUserFromSession(session);

        assert loginUser != null;
        if(!question.isSameUser(loginUser)){
            throw new IllegalArgumentException();
        }

        return jspView("/qna/updateForm.jsp").addObject("question",question);
    }
}
