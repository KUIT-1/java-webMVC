package jwp.controller.SubController;

import core.db.MemoryUserRepository;
import jwp.controller.Controller;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String userId = req.getParameter("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        user.update(new User(
                req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email")
        ));

        MemoryUserRepository.getInstance().changeUserInfo(user);


        return "redirect:/user/list";
    }
}
