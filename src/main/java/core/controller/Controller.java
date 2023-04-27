package core.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller { // for MVC pattern : 클라이언트의 요청에 대한 처리를 담당
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
