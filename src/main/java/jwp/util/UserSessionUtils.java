package jwp.util;

import jwp.model.User;

import javax.servlet.http.HttpSession;

public class UserSessionUtils {
    static final String USER_SESSION_KEY = "user";

    public static User getUserFromSession(HttpSession session) {
        Object user = session.getAttribute(USER_SESSION_KEY);
        if (user != null) {
            return (User) user;
        }
        return null;
    }

    public static boolean isLogin(HttpSession session) {
        return getUserFromSession(session) != null;
    }
}
