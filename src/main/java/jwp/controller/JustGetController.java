package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JustGetController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return req.getRequestURI();
    }
}