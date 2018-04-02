package dolphinweb.controllers;

import combine.UserComposite;
import model.ResponseCode;
import model.RestApiResponse;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;
import utils.CustomWebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jiangtingqiang@gmail.com
 * @create 2017-08-06-10:51 PM
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserComposite userComposite;

    @Autowired
    private CustomWebUtils customWebUtils;

    @RequestMapping("reg")
    public RestApiResponse<Integer> getUserShelfBooks(User user) {
        int registResult = userService.createUser(user);
        return new RestApiResponse<>(ResponseCode.REQUEST_SUCCESS_MESSAGE, ResponseCode.REQUEST_SUCCESS, registResult);
    }

    @RequestMapping("login")
    public RestApiResponse<User> login(User user, HttpServletResponse response) {
        User isLoginSuccess = userComposite.Login(user.getName(), user.getPassword());
        if (isLoginSuccess == null) {
            Cookie cookie = customWebUtils.createCookie("cookie1", "dolphin");
            response.addCookie(cookie);
        }
        return new RestApiResponse<>(ResponseCode.REQUEST_SUCCESS_MESSAGE, ResponseCode.REQUEST_SUCCESS, isLoginSuccess);
    }
}
