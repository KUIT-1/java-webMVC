package core.mvc;

import jwp.controller.*;

import java.util.HashMap;

public class RequestMapper {
    private static HashMap<String, Controller> requestMap = new HashMap<>();

    static {
        requestMap.put("/", new HomeController());
        requestMap.put("/home.jsp", new HomeController());
        requestMap.put("/user/signup", new CreateUserController());
        requestMap.put("/user/userList", new ListUserController());
        requestMap.put("/user/login", new LoginController());
        requestMap.put("/user/logout", new LogoutController());
        requestMap.put("/user/update", new UpdateUserController());
        requestMap.put("/user/updateForm", new UpdateUserFormController());
    }

    public static Controller get(String url){
        if(requestMap.containsKey(url)){
            System.out.print("url : "+url);
            return requestMap.get(url);
        }
        System.out.print("url : "+url);

        return new JustGetController();
    }

}
