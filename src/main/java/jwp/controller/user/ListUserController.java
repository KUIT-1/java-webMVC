package jwp.controller.user;

import core.mvc.Controller;
import core.db.MemoryUserRepository;
import jwp.dao.UserDao;
import jwp.util.UserSessionUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ListUserController implements Controller {
    UserDao userDao = new UserDao();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        if(UserSessionUtils.isLogin(request.getSession())){
            // login 한 상태라면
            request.setAttribute("users", userDao.findAll());
            return "/user/list.jsp";
        }
        // logout 한 상태라면
        return "redirect:/user/loginForm"; // 로그인 패이지로 redirect
    }
}