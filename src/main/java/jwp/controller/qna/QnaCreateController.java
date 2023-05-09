package jwp.controller.qna;

import core.mvc.*;
import jwp.dao.QuestionDao;
import jwp.model.Question;
import jwp.support.context.ContextLoaderListener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.logging.Logger;

public class QnaCreateController extends AbstractController {
    QuestionDao questionDao = new QuestionDao();
    private static final Logger logger = Logger.getLogger(ContextLoaderListener.class.getName());

    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        Question question = new Question(params.get("writer"),
                params.get("title"),
                params.get("contents"));

        Question que = questionDao.insert(question);

        return jspView("redirect:/");
    }
}
