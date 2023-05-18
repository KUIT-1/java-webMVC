package jwp.controller;

import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserFormController implements Controller {
    @Override
    public view execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        req.setAttribute("userId",userId);
        return new JspView("/user/Updateform.jsp");
    }
}