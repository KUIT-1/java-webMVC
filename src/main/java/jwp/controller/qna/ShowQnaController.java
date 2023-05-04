package jwp.controller.qna;

import core.mvc.Controller;
import jwp.dao.AnswerDao;
import jwp.dao.QuestionDao;
import jwp.model.Answer;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowQnaController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String questionId = req.getParameter("questionId");
        Question question = new QuestionDao().findById(Integer.parseInt(questionId));
        List<Answer> answers = new AnswerDao().findAllByQuestionId(Integer.parseInt(questionId));

        req.setAttribute("question", question);
        req.setAttribute("answers",answers);

        return "/qna/show.jsp";
    }
}
