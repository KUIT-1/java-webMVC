package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns="/user/user")
public class UpdateUserFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**
         * 1.쿼리 파라미터에서 userId 정보를 찾아서 userId 변수에 저장
         * 2.해당 userId를 이용해서 user 객체 찾기
         * 3.updateForm.jsp에 찾은 user 객체 정ㅂ조를 넣어둔 후 홈화면으로 리다이렉트
         */

        String userId=req.getParameter("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if(user!=null){
            req.setAttribute("user",userId);
            RequestDispatcher rd = req.getRequestDispatcher("updateForm.jsp");
            rd.forward(req,resp);
            return;
        }

        resp.sendRedirect("/");
    }
}