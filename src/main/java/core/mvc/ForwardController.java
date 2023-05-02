package core.mvc;

import core.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForwardController implements Controller {
    // 특별한 로직을 구현하지 않고 단순히 view 에 대해 이동만 담당하는 경우에는
    // ForwardController 에서 처리한다.
    private final String redirectURL;

    public ForwardController(String url) {
        this.redirectURL = url;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return redirectURL;
    }
}
