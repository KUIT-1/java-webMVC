package jwp.controller;

import core.mvc.Controller;
import org.apache.catalina.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QnaFormController implements Controller
{

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        HttpSession session = req.getSession();

        if(session.getAttribute("user") == null) return "/user/loginForm";

        return "/qna/form.jsp";
    }
}
