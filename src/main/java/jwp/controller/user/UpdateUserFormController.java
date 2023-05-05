package jwp.controller.user;

import core.mvc.Controller;
import core.db.MemoryUserRepository;
import jwp.dao.UserDao;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class UpdateUserFormController implements Controller {
    UserDao userDao = new UserDao();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String userId = request.getParameter("userId");
        //User user = MemoryUserRepository.getInstance().findUserById(userId); // request 에서 받은 id 를 통해 user 를 get
        User user = userDao.findByUserId(userId);
        if(user!=null){ // user 가 null 이 아니라면 updateForm.jsp 로
            request.setAttribute("user", user);
            return "/user/updateForm.jsp";
        }
        return "redirect:/"; // user  가 null 이면 home 으로 redirect
    }
}
