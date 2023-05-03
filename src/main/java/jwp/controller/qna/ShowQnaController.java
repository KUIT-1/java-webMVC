package jwp.controller.qna;

import core.mvc.Controller;
import jwp.dao.QuestionDao;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowQnaController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Question question = new QuestionDao().findById(Integer.parseInt(req.getParameter("questionId")));
        req.setAttribute("question", question);

        return "/qna/show.jsp";
    }
}
