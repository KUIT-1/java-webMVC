package core.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class JsonView implements View{
    @Override
    public void render(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //Json 데이터를 사용자에게 전달
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(mapper.writeValueAsString(createModel(request)));

        // 전달되는 Json 객체
        // {
        //      answer : {
        //                  answerId : 1
        //                  questionId : 1
        //      }
        // }
    }

    private static Map<String , Object> createModel(HttpServletRequest request) {
        Enumeration<String> names = request.getAttributeNames();
        Map<String , Object> model = new HashMap<>();

        while (names.hasMoreElements()){
            String name = names.nextElement();
            model.put(name, request.getAttribute(name));  //name="answer", request.getAttribute(name)=savedAnswer(Answer객체)
        }
        return model;
    }


}
