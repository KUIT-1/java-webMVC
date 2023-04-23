package jwp.util;

import jwp.model.User;

import javax.servlet.http.HttpSession;

public class UserSessionUtil {
    private final static String USER_SESSION_KEY = "user";
    private static HttpSession httpSession;

    public static User getUser(HttpSession session){
        Object user = session.getAttribute(USER_SESSION_KEY);
        if(user==null){
            return null;
        }
        return (User) user;
    }

    public static boolean isLogined(HttpSession session){
        return getUser(session) != null;
    }

    public static void login(HttpSession session, User user){
        session.setAttribute(USER_SESSION_KEY, user);
    }

    public static void logout(HttpSession session){
        session.removeAttribute(USER_SESSION_KEY);
    }
}
