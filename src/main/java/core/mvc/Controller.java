package core.mvc;

import core.mvc.view.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public interface Controller {
    view execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException;
}
