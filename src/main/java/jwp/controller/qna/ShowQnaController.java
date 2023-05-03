package jwp.controller.qna;

import jwp.controller.Controller;
import jwp.dao.AnswerDao;
import jwp.dao.QuestionDao;
import jwp.model.Answer;
import jwp.model.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ShowQnaController implements Controller {
    QuestionDao questionDao = new QuestionDao();
    AnswerDao answerDao= new AnswerDao();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        int qId = Integer.parseInt(req.getParameter("questionId"));
        Question question = questionDao.findByQuestionId(qId);
        System.out.println(qId);
        List<Answer> answers = answerDao.findByQuestionId(qId);
        if(question == null) return "redirect:/";
        req.setAttribute("question",question);
        req.setAttribute("answers",answers);
        return "show.jsp";
    }
}
