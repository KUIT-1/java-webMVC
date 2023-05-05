package jwp.controller.questions;

import core.mvc.Controller;
import jwp.dao.QuestionDao;
import jwp.model.Question;
import jwp.model.User;
import jwp.util.UserSessionUtils;
import org.apache.catalina.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class UpdateQuestionController implements Controller {
    QuestionDao questionDao = new QuestionDao();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        if(!UserSessionUtils.isLogin(session)){
            return "redirect:/users/loginForm";
        }
        // status : login
        int questionId = Integer.parseInt(request.getParameter("questionId"));
        Question question = questionDao.findByQuestionId(questionId);

        Optional<User> user = Optional.ofNullable(UserSessionUtils.getUserFromSession(session));
        user.filter(question::isSameUser)
                .orElseThrow(IllegalArgumentException::new);

        question.update(request.getParameter("title"), request.getParameter("contents"));
        questionDao.update(question);
        return "redirect:/";
    }
}
