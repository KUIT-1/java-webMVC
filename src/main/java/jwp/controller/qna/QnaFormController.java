package jwp.controller.qna;

import core.db.MemoryUserRepository;
import jwp.controller.Controller;
import jwp.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class QnaFormController implements Controller {
    private static final String USER_SESSION_KEY = "user";
    QuestionDao questionDao = new QuestionDao();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        HttpSession session = req.getSession();
        Object value = session.getAttribute(USER_SESSION_KEY);

        if (value == null) {
            return "redirect:/";
        }

        return "/qna/form.jsp";
    }
}
