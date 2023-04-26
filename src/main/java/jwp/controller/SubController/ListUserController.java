package jwp.controller.SubController;

import core.db.MemoryUserRepository;
import jwp.controller.Controller;
import jwp.model.User;

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
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        // 세션에 저장된 정보 가져오기
        HttpSession session = req.getSession();
        Object value = session.getAttribute("user");
        if (value != null) {
            User user = (User) value;
            req.setAttribute("user", user);
            return "/user/ulist";
        }
        return "redirect:/user/loginForm";
    }

}
