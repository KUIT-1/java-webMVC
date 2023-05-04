package jwp.controller;

import core.controller.Controller;
import core.db.MemoryUserRepository;
import jwp.session.UserSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListUserController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(UserSession.isLogin(request.getSession())){
            // login 한 상태라면
            request.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            return "/user/list.jsp";
        }
        // logout 한 상태라면
        return "redirect:/user/login.jsp"; // 로그인 패이지로 redirect
    }
}