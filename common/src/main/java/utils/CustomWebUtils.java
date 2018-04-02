package utils;

import org.springframework.stereotype.Component;
import javax.servlet.http.Cookie;

@Component
public class CustomWebUtils {

    public Cookie createCookie(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        return cookie;
    }

}
