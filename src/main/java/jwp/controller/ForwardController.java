package jwp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController implements Controller{

    private final String uri;

    public ForwardController(String uri) {
        this.uri = uri;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return uri;
    }
}
