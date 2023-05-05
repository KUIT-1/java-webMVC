package jwp.controller;

import core.mvc.Controller;
import jwp.dao.UserDao;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateUserController implements Controller {

    /**
     * 요청에서 사용자 정보를 가져와서 이를 바탕으로
     * UserDao를 통해 데이터베이스에 새로운 사용자 정보 저장
     */


    //데이터베이스와의 상호작용을 위한 Data Access Object
    UserDao userDao = new UserDao();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        /**
         * 새로운 사용자 정보를 생성하고 UserDao를 이용하여 데이터베이스에 저장
         */

        User user = new User(req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));

        userDao.insert(user);
        return "redirect:/user/list";
    }
}
