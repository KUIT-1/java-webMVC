package jwp.controller;

<<<<<<< HEAD
import core.mvc.Controller;
import jwp.dao.UserDao;
import jwp.util.UserSessionUtils;
=======
import core.db.MemoryUserRepository;
import jwp.Util.UserSessionUtils;
>>>>>>> 0ae3de14b2a46d613396668cc8c5d3d0f43488e3

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListUserController implements Controller {
    UserDao userDao = new UserDao();

    @Override
<<<<<<< HEAD
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (UserSessionUtils.isLogined(req.getSession())) {
            req.setAttribute("users", userDao.findAll());
            return "/user/list.jsp";
        }
        return "redirect:/user/loginForm";
=======
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (UserSessionUtils.isLogined(req.getSession())) {
            req.setAttribute("users", MemoryUserRepository.getInstance().findAll());
            RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
            rd.forward(req,resp);
        }

>>>>>>> 0ae3de14b2a46d613396668cc8c5d3d0f43488e3
    }
}
