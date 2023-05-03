package jwp.controller.qna;

import core.mvc.Controller;
import jwp.dao.QuestionDao;
import jwp.model.Question;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateQnaController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user == null) {
            return "/user/loginForm";
        }

        User loginUser = (User) user;
        String questionId = req.getParameter("questionId");

        Question question = new QuestionDao().findById(Integer.parseInt(questionId));
        if (!loginUser.getName().equals(question.getWriter())) {
            throw new IllegalArgumentException();
        }

        question.update(
                req.getParameter("writer"),
                req.getParameter("title"),
                req.getParameter("contents")
        );

        new QuestionDao().update(question);

        return "redirect:/";
    }
}
