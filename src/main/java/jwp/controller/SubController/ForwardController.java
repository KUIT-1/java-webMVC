package jwp.controller.SubController;

import jwp.controller.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController implements Controller {

    String S;
    public ForwardController(String S) {
        this.S = S;
    }
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return S;
    }
}
