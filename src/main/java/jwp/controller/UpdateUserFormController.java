package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
UpdateUserFormController는 해당 요청을 받아 /user/update.jsp로 userId를 바탕으로 사용자 정보를 알아와 전달하며 forward한다.
 */
@WebServlet("/user/updateForm")
public class UpdateUserFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        System.out.println(userId);
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        System.out.println(user);
        if(user!=null){
            System.out.println("user is not null!!");
            request.setAttribute("user", user);
            String path = "/user/updateForm.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(path);
            dispatcher.forward(request, response);
            return;
        }
        response.sendRedirect("/");
    }
}
