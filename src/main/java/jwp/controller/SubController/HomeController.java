package jwp.controller.SubController;


import core.db.MemoryUserRepository;
import jwp.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class HomeController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "/home.jsp";
    }
}
