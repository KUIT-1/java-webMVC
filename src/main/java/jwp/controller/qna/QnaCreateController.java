package jwp.controller.qna;

import core.mvc.Controller;
import jwp.dao.QuestionDao;
import jwp.model.Question;
import jwp.model.User;
import jwp.support.context.ContextLoaderListener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

public class QnaCreateController implements Controller {
    QuestionDao questionDao = new QuestionDao();
    private static final Logger logger = Logger.getLogger(ContextLoaderListener.class.getName());

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Question question = new Question(req.getParameter("writer"),
                req.getParameter("title"),
                req.getParameter("contents"));

        Question que = questionDao.insert(question);
        logger.info(que.getWriter());
        logger.info(que.getTitle());
        logger.info(que.getContents());
        logger.info(que.getCreatedDate().toString());

        return "redirect:/";
    }
}
