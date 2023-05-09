package jwp.controller;

import core.mvc.*;
import jwp.dao.QuestionDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


public class HomeController extends AbstractController {
    QuestionDao questionDao = new QuestionDao();
    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        return jspView("/home.jsp").addObject("questions", questionDao.findAll());
    }
}
