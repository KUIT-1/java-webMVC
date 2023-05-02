package jwp.controller;

import core.mvc.Controller;
import jwp.dao.QuestionDao;
import jwp.model.Question;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateQnaController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        if (!UserSessionUtils.isLogined(session)) {
            return "/user/loginForm";
        }

        Question question = new QuestionDao().insert(new Question(
                req.getParameter("writer"),
                req.getParameter("title"),
                req.getParameter("contents")
        ));

        req.setAttribute("question", question);

        return "redirect:/qna/show";
    }
}
