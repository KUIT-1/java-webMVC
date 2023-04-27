package core.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller { // for MVC pattern
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
