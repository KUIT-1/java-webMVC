package jwp.controller.questions;

import core.mvc.Controller;
import jwp.util.UserSessionUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class FormQuestionController  implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        if(UserSessionUtils.isLogin(request.getSession())){
            // login 한 상태라면
            return "/qna/form.jsp";
        }
        // logout 한 상태라면
        return "redirect:/user/loginForm"; // 로그인 패이지로 redirect
    }
}
