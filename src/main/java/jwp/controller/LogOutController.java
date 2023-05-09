package jwp.controller;

import core.mvc.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;


public class LogOutController extends AbstractController {

    HttpSession session;

    @Override
    public void setSession(HttpSession httpSession) {
        this.session = httpSession;
    }
    @Override
    public ModelAndView execute(Map<String, String> params) throws Exception {
        session.removeAttribute("user");
        return jspView("redirect:/");
    }
}
