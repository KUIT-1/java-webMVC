package core.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractController implements Controller{ // ModelAndView 객체 만드는 책임을 짐
    protected ModelAndView jspView(String forwardUrl){
        return new ModelAndView(new JspView(forwardUrl));
    }

    protected ModelAndView jsonView(){
        return new ModelAndView(new JsonView());
    }

}
