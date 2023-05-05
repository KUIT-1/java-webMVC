package jwp.controller;

import core.mvc.Controller;
import jwp.dao.QuestionDao;
import jwp.model.Question;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QnaFormController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        /**
         * HttpSession 객체를 얻어와서 해당 세션이 로그인 상태인지 확인
         */

        HttpSession session = req.getSession();
        if (!UserSessionUtils.isLogined(session)) {
            return "/user/loginForm";
        }
        /**
         * 로그인이 된 상태
         */

        return "/qna/form.jsp";
    }
}
