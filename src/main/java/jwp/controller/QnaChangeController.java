package jwp.controller;

import core.mvc.Controller;
import jwp.dao.QuestionDao;
import jwp.model.Question;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QnaChangeController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        QuestionDao questionDao = new QuestionDao();
        Question question = questionDao.findByQuestionId(Long.parseLong(req.getParameter("questionId")));
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if(user.getUserId() != question.getWriter()) throw new IllegalArgumentException();

        question.setTitle(req.getParameter("title"));
        question.setContents(req.getParameter("contents"));
        questionDao.update(question);


        return "/";
    }
}
