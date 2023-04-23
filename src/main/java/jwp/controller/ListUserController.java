package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;
import jwp.util.UserSessionUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ListUserController implements Controller {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //세션에 저장된 정보 가져오기
        HttpSession session = req.getSession();
        User value = UserSessionUtil.getUser(session);

        if (UserSessionUtil.isLogined(session)) {
            User user = value;
            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            req.setAttribute("loginUser", user);
            return "/user/list.jsp";
        }

        return "Redirect:/user/loginForm";
    }
}
