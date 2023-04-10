package jwp.controller;

import core.db.MemoryUserRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserFormController  implements Controller{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("user", MemoryUserRepository.getInstance().findUserById(req.getParameter("userId")));
        return "/user/updateForm.jsp";
    }
}
