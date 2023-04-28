package jwp.controller.SubController;


import core.db.MemoryUserRepository;
import jwp.controller.Controller;
import jwp.model.User;
import org.apache.catalina.users.MemoryUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserFormController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if(user != null)
            req.setAttribute("user", user);
        return "/user/updateUserForm";
    }

}
