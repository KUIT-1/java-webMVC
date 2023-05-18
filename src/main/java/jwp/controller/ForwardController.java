package jwp.controller;

import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForwardController implements Controller {
    private String forwardUrl;

    public ForwardController(String forwardUrl) {
        this.forwardUrl = forwardUrl;
    }

    @Override
    public view execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        return new JspView(forwardUrl);
    }
}
