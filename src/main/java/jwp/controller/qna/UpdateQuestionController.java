package jwp.controller.qna;

import core.mvc.*;
import jwp.dao.QuestionDao;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


public class UpdateQuestionController extends AbstractController {
    QuestionDao questionDao = new QuestionDao();

    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        String questionId = params.get("questionId");
        Question question = questionDao.findByQuestionId(Integer.parseInt(questionId));

        question.updateTitleAndContents(params.get("title"), params.get("contents"));
        questionDao.update(question);

        return jspView("redirect:/");
    }
}
