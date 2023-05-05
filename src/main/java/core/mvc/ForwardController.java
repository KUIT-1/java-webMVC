package core.mvc;

import core.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController implements Controller {

    /**
     * 특정 URL로 포워딩(forwarding)하는 기능을 제공
     * 생성자에서 이동할 URL을 받아서 저장하고, execute() 에서는 저장된 URL을 반환한다.
     */
    private String forwardUrl;

    public ForwardController(String forwardUrl) {

        this.forwardUrl = forwardUrl;
        if (forwardUrl == null) {
            throw new NullPointerException("forwardUrl is null. 이동할 URL을 입력하세요.");
        }
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        System.out.println("ForwardController execute 함수");
        return forwardUrl;
    }
}
