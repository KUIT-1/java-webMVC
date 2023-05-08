package jwp.controller.qna;

import core.mvc.Controller;
import core.mvc.JspView;
import core.mvc.View;
import jwp.util.UserSessionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormController implements Controller {
    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (UserSessionUtils.isLogined(req.getSession())) {
            return new JspView("/qna/form.jsp");
        }
        return new JspView("redirect:/user/loginForm");
    }
}