package core.mvc.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface view {
    void render(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
