package jwp.controller;

import core.mvc.Controller;
import jwp.dao.QuestionDao;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Qna423FormController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        QuestionDao questionDao = new QuestionDao();
        long qId = Long.parseLong(req.getParameter("questionId"));
        Question question = questionDao.findByQuestionId(qId);

        req.setAttribute("question", question);

        return "/qna/form423.jsp";
    }
}
