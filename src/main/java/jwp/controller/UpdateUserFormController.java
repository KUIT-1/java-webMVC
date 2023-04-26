package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateUserFormController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        // 세션에 저장된 정보 가져오기
        HttpSession session = req.getSession();
        Object value = session.getAttribute("user");
        if (value == null) {
            return "redirect:/user/login";
        }
        User sessionUser = (User) value;
        User userById = MemoryUserRepository.getInstance().findUserById(req.getParameter("userId"));

        if (!userById.isSameUser(sessionUser.getUserId())) {
            return "redirect:/user/list";
        }

        req.setAttribute("user", userById);

        return "/user/updateForm";
    }
}
