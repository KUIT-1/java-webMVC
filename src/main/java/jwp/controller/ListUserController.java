package jwp.controller;

import core.db.MemoryUserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListUserController implements Controller{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("userId");

        // 리스트 확인 제한 -> 로그인 요청
        if(userId == null){
            return REDIRECT + "/user/login.jsp";
        }

        req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
        return "/user/list.jsp";
    }
}
